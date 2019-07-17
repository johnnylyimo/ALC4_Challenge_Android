package com.example.alc4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAbout.setOnClickListener{
            startActivity(Intent(this, AboutActivity::class.java))
        }


        btnProfile.setOnClickListener{
            startActivity(Intent(this, my_profile::class.java))
        }




    }
}
