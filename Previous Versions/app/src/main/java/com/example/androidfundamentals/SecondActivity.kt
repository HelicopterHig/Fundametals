package com.example.androidfundamentals


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androidfundamentals.databinding.ActivitySecondBinding
import android.content.Intent
import android.util.Log



class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding


    private val MESSAGE1 = "asd"
    private val EXTRA_REPLY = "com.example.android.androidfundamentals.extra.REPLY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFromZeroActivity()
        returnReply()
    }

    private fun returnReply(){
        binding.buttonSecond.setOnClickListener {
            val intent = Intent()
            val message = binding.editText.text
            intent.putExtra(EXTRA_REPLY, message.toString() )
            setResult(RESULT_OK, intent )
            Log.d("LOG_TAG", "End SecondActivity");
            finish()
        }
    }

    private fun getDataFromZeroActivity(){
        val intent = intent
        val message = intent.getStringExtra(MESSAGE1)
        binding.textMessage.text = message.toString()
        Log.d("secondActivity", message.toString())
    }
}