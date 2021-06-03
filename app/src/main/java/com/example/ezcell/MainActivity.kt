package com.example.ezcell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnR : Button = findViewById(R.id.btnRegister)
        btnR.setOnClickListener {
            Intent( this@MainActivity,RegisterActivity::class.java ).also {
                startActivity(it)
            }

        }

    }
}