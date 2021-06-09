package com.example.ezcell.util

import android.app.Activity
import android.app.ProgressDialog
import android.net.Uri
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Toast
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject
import java.io.File

class UploadUtility(activity: Activity) {
    private val activity = activity
    private val apiURL: String = "http://34.126.159.168/process-malaria"
    private val client = OkHttpClient()
    var dialog: ProgressDialog? = null

    fun uploadFile(sourceFileUri: Uri, uploadedFileName: String? = null) {
        val pathFromUri = URIPathHelper().getPath(activity,sourceFileUri)
        uploadFile(File(pathFromUri), uploadedFileName)
    }

    fun uploadFile(sourceFile: File, uploadedFileName: String? = null) {
        Thread {
            val mimeType = getMimeType(sourceFile);
            if (mimeType == null) {
                return@Thread
            }
            val fileName: String = if (uploadedFileName == null)  sourceFile.name else uploadedFileName

            toggleProgressDialog(true)

            try {
                val requestBody: RequestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", fileName, sourceFile.asRequestBody(mimeType.toMediaTypeOrNull()))
                    .build()

                val request: Request = Request.Builder()
                    .url(apiURL)
                    .post(requestBody)
                    .build()

                val response: Response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    val res = JSONObject(response.body?.string())
                    val resResult = res.getString("result")
                } else {
                    Log.e("File upload", "failed")
                    showToast("File uploading failed with error $response")
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                Log.e("File upload", "Failed with error $ex")
                showToast("File uploading failed with error $ex")
            }

            toggleProgressDialog(false)
        }.start()
    }

    fun getMimeType(file: File): String? {
        var type: String? = null
        val extension = MimeTypeMap.getFileExtensionFromUrl(file.path)

        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        }

        return type
    }

    fun showToast(message: String) {
        activity.runOnUiThread {
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }
    }

    fun toggleProgressDialog(show: Boolean) {
        activity.runOnUiThread {
            if (show) {
                dialog = ProgressDialog.show(activity, "", "Uploading file...", true);
            } else {
                dialog?.dismiss();
            }
        }
    }
}