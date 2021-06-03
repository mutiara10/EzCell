package com.example.ezcell.fm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ezcell.MainActivity
import com.example.ezcell.R
import com.example.ezcell.databinding.FragmentHistoryBinding
import com.google.firebase.auth.FirebaseAuth

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHistoryBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()

        (binding.btnLogout).setOnClickListener {
            auth.signOut()
            Intent(activity, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}