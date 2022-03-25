package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.databinding.ActivityHomeTaskBinding
import com.example.androidfundamentals.databinding.ActivityScrollingTxtBinding

class ScrollActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingTxtBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingTxtBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}