package com.margsglobal.marsonkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import kotlinx.android.synthetic.main.activity_store.*

class store : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

         storeview.webChromeClient = WebChromeClient()

        // this will load the url of the website
        storeview.loadUrl("https://marsonesell.weebly.com/store-details.html/")

        // this will enable the javascript settings
        storeview.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        storeview.settings.setSupportZoom(false)

    }
}