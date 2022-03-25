package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivityMainBinding
import com.example.androidfundamentals.databinding.ActivityMainLinearBinding
import com.example.androidfundamentals.databinding.ActivityHomeTaskBinding



class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    //private lateinit var binding: ActivityMainLinearBinding
    private lateinit var binding: ActivityHomeTaskBinding
    var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //binding =ActivityMainLinearBinding.inflate(layoutInflater)
        binding =ActivityHomeTaskBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

         binding.buttonToast.setOnClickListener {
             Toast.makeText(this, R.string.toastMessage,  Toast.LENGTH_SHORT).show()
         }

        binding.buttonCount.setOnClickListener {
            i++
            binding.textView.text = i.toString()
        }

        binding.zero.setOnClickListener {
            i = 0
            binding.textView.text = i.toString()
        }
    }



}