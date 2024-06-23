package com.example.bataille_navale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val isWin = intent.extras?.getString("ISWIN")
        val currentScore = intent.extras?.getString("SCORE")

        //Si le score est null, alors il est égale à 0
        val currentScoreNumber = currentScore?.toInt() ?: 0

        findViewById<TextView>(R.id.isWin).text = isWin
        if(currentScoreNumber == 1){
            findViewById<TextView>(R.id.score).text = "${currentScore} attempt"
        }
        if(currentScoreNumber > 1){
            findViewById<TextView>(R.id.score).text = "${currentScore} attempts"
        }


        findViewById<Button>(R.id.goHome).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}