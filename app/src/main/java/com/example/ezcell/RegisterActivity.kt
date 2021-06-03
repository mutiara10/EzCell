package com.example.ezcell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.ezcell.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        (binding.btnRegister).setOnClickListener {
            // TODO check if any form empty

            val email = binding.email.text.toString()
            val password = binding.ezPassword.text.toString()

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Intent(this, HomeActivity::class.java).also {
                        startActivity(it)
                    }
                    finish()
                }
            }.addOnFailureListener { exception  ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
//            Intent( this@RegisterActivity,MainActivity::class.java ).also {
//                startActivity(it)
//            }
        }
    }
}