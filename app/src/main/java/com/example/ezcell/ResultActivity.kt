package com.example.ezcell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ezcell.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDetectResult.text = intent.getStringExtra(EXTRA_DETECT_RESULT)
    }

    companion object {
        const val EXTRA_DETECT_RESULT = "extra_detect_result"
    }
}