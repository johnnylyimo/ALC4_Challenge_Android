package com.example.alc4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_profile.*

class my_profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        supportActionBar?.title = getString(R.string.my_profile)

        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show()


    }
}
