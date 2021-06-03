package com.example.ezcell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnL : Button = findViewById(R.id.btnLgn)
        btnL.setOnClickListener {
            Intent( this@RegisterActivity,MainActivity::class.java ).also {
                startActivity(it)
            }
        }

    }
}