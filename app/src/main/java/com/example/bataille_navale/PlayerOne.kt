package com.example.bataille_navale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PlayerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)

        val currentDifficulty = intent.extras?.getString("DIFFICULTY")
        findViewById<TextView>(R.id.currentDifficulty).text = currentDifficulty

        val A1 = findViewById<TextView>(R.id.A1)
        val B1 = findViewById<TextView>(R.id.B1)
        val C1 = findViewById<TextView>(R.id.C1)
        val D1 = findViewById<TextView>(R.id.D1)
        val A2 = findViewById<TextView>(R.id.A2)
        val B2 = findViewById<TextView>(R.id.B2)
        val C2 = findViewById<TextView>(R.id.C2)
        val D2 = findViewById<TextView>(R.id.D2)
        val A3 = findViewById<TextView>(R.id.A3)
        val B3 = findViewById<TextView>(R.id.B3)
        val C3 = findViewById<TextView>(R.id.C3)
        val D3 = findViewById<TextView>(R.id.D3)
        val A4 = findViewById<TextView>(R.id.A4)
        val B4 = findViewById<TextView>(R.id.B4)
        val C4 = findViewById<TextView>(R.id.C4)
        val D4 = findViewById<TextView>(R.id.D4)


        if(currentDifficulty == "easy") {

        }
        if(currentDifficulty == "difficult") {

        }
    }
}