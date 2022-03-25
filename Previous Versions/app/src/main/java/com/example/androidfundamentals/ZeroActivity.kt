package com.example.androidfundamentals

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.core.view.isVisible
import com.example.androidfundamentals.databinding.ActivityZeroBinding
import org.w3c.dom.Text

class ZeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZeroBinding



    private val MESSAGE1 = "asd"
    private val EXTRA_REPLY = "com.example.android.androidfundamentals.extra.REPLY"
    private var laucher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZeroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)





        laucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            if( result.resultCode == RESULT_OK){
                val text = result.data?.getStringExtra(EXTRA_REPLY)
                binding.textMessageReply.text = text.toString()
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.visibility = View.VISIBLE
            }
        }
        getResult()

        if ( savedInstanceState!= null ){
            val isVisible: Boolean = savedInstanceState.getBoolean("reply_visible")
            if ( isVisible){
                binding.textHeaderReply.visibility= View.VISIBLE
                binding.textMessageReply.text = savedInstanceState.getString("reply_text")
                binding.textMessageReply.visibility = View.VISIBLE


            }
        }
        launchSecondActivity()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (binding.textMessageReply.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", binding.textMessageReply.text.toString())
        }

    }

    private fun launchSecondActivity(){
        val message = binding.editTextMain.text
        binding.send.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(MESSAGE1, message.toString())
            laucher?.launch(intent)
            Log.d("zeroActivity", message.toString())
        }
    }

    private fun getResult(){
        val intent = intent
        val reply = intent.getStringExtra(EXTRA_REPLY)
        binding.textMessageReply.text = reply.toString()
    }


    override fun onStart() {
        super.onStart()
        Log.d("LOG_TAG", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LOG_TAG", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LOG_TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LOG_TAG", "onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LOG_TAG", "onResume")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LOG_TAG", "onDestroy")
    }




}