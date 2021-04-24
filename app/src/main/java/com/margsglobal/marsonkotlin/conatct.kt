package com.margsglobal.marsonkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_sell.*

class conatct : AppCompatActivity() {

    lateinit var adView : AdView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conatct)

        adView = findViewById<View>(R.id.adView) as AdView
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)



    }

    fun call(view:View) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:+919962155269"))
        startActivity(intent)
    }

    fun whatsapp(view: View) {
        val uri =
            Uri.parse("https://wa.me/+919962155269")

        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }



    fun mail(view: View) {
        sendEmail()
    }

    protected fun sendEmail() {
        Log.i("Send email", "")
        val TO = arrayOf<String>("margsglobal@gmail.com")
        val CC = arrayOf<String>("rabdulzaman@gmail.com")
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.setData(Uri.parse("mailto:"))
        emailIntent.setType("text/plain")
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO)
        emailIntent.putExtra(Intent.EXTRA_CC, CC)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Found a bug")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I found a bug - ")
        try
        {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            finish()

        }
        catch (ex:android.content.ActivityNotFoundException) {

        }
    }


    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}