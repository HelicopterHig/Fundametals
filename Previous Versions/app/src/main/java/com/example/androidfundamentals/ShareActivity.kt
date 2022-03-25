package com.example.androidfundamentals

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ShareCompat
import com.example.androidfundamentals.databinding.ActivityShareBinding

class ShareActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openWebsite()
        openLocation()
        shareText()
        findShop()

    }



    fun openWebsite() {
        binding.openWebsiteButton.setOnClickListener {
            val url = binding.websiteEditText.text.toString()
            val webpage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this!")
            }
        }
    }

    fun openLocation() {
        binding.openLocationButton.setOnClickListener {
        // Получить строку, указывающую местоположение. ввод не подтвержден; это
        // передается обработчику местоположения без изменений.
        val loc = binding.locationEditText.text.toString()

        // Разбираем местоположение и создаем намерение.
        var addressUri : Uri = Uri.parse("geo:0,0?q=$loc")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            // Найдите действие для обработки намерения и запустите это действие.
            if (intent.resolveActivity(packageManager) != null ){
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this!")
            }
        }
    }

    fun shareText() {
        binding.shareTextButton.setOnClickListener {
            val txt = binding.shareEditText.text.toString()
            val mimeType : String = "text/plain"

            ShareCompat.IntentBuilder(this)
                .setType(mimeType)                            // MIME-тип элемента для совместного использования.
                .setChooserTitle("Share this text with: ")   //Название, которое отображается в меню выбора системных приложений.
                .setText(txt)                               // Фактический текст, которым нужно поделиться
                .startChooser()                           // Покажите средство выбора системных приложений и отправьте файл Intent.
        }
    }

    fun findShop() {
        binding.findTextButton.setOnClickListener {
            // Получить строку, указывающую местоположение. ввод не подтвержден; это
            // передается обработчику местоположения без изменений.
            val loc = binding.findEditText.text.toString()

            // Разбираем местоположение и создаем намерение.
            var addressUri : Uri = Uri.parse("geo:0,0?q=$loc")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            // Найдите действие для обработки намерения и запустите это действие.
            if (intent.resolveActivity(packageManager) != null ){
                startActivity(intent)
            } else {
                Log.d("ImplicitIntents", "Can't handle this!")
            }
        }
    }


}