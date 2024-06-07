package com.example.bataille_navale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PlayerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)

        findViewById<TextView>(R.id.currentDifficulty).text = intent.extras?.getString("DIFFICULTY")
    }
}