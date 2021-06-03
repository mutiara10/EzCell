package com.example.ezcell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ezcell.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser?.displayName != "") {
            // Maybe broken
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }

        (binding.btnRegister).setOnClickListener {
            Intent( this@MainActivity,RegisterActivity::class.java ).also {
                startActivity(it)
            }
        }
    }
}