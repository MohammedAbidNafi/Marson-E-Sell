package com.margsglobal.marsonkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        cardsell.setOnClickListener {
            startActivity(Intent(this, sell::class.java))
        }
        cardabout.setOnClickListener {
            startActivity(Intent(this, about::class.java))
        }
        cardcontact.setOnClickListener {
            startActivity(Intent(this, conatct::class.java))
        }

        map.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        reviewbtn.setOnClickListener {
            startActivity(Intent(this, review::class.java))
        }


    }

    override fun onBackPressed() {
        val exitIntent = Intent(Intent.ACTION_MAIN)
        exitIntent.addCategory(Intent.CATEGORY_HOME)
        exitIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(exitIntent)
    }



}