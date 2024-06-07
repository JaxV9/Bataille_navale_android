package com.example.bataille_navale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val isWin = intent.extras?.getString("ISWIN")
        val currentScore = intent.extras?.getString("SCORE")

        findViewById<TextView>(R.id.isWin).text = isWin
        findViewById<TextView>(R.id.score).text = currentScore

    }
}