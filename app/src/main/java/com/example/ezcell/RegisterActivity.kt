package com.example.ezcell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.ezcell.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("emailnjya", "aadw")

        (binding.btnRegister).setOnClickListener {
            Log.i("emailnjya", binding.email.text.toString())
            Log.i("nama", binding.nama.text.toString())
            Log.i("password", binding.ezpassword.text.toString())
//            Intent( this@RegisterActivity,MainActivity::class.java ).also {
//                startActivity(it)
//            }
        }
    }
}