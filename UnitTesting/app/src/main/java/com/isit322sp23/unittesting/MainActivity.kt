package com.isit322sp23.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class Game(highest: Int = 0) {
    var currentScore = 0
        private set

    var highestScore = highest
        private set

    fun incrementScore() {
        currentScore++

        if (currentScore > highestScore) {
            highestScore = currentScore
        }
    }
}