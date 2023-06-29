package com.isit322sp23.ridealongmarcus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val output = findViewById<Button>(R.id.button)

        output.setOnClickListener{
            findViewById<TextView>(R.id.message).text = "Confirmation"
        }
    }

    fun onClick(){}

}