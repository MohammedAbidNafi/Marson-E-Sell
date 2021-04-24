package com.margsglobal.marsonkotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import kotlinx.android.synthetic.main.activity_about.*

class about : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
       // aboutview.webChromeClient = WebChromeClient()

        // this will load the url of the website
        //aboutview.loadUrl("https://marsonesell.weebly.com/")

        // this will enable the javascript settings
        //aboutview.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
       // aboutview.settings.setSupportZoom(false)

        sellbutton.setOnClickListener {
            startActivity(Intent(this, sell::class.java))
        }
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }



}




