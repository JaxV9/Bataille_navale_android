package com.example.bataille_navale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val easyBtn = findViewById<Button>(R.id.buttonEasy)
        val difficultBtn = findViewById<Button>(R.id.buttonDifficult)

        easyBtn.setOnClickListener {
            val intent = Intent(this, PlayerOne::class.java)
            intent.putExtra("DIFFICULTY", "easy")
            startActivity(intent)
        }
        difficultBtn.setOnClickListener {
            val intent = Intent(this, PlayerOne::class.java)
            intent.putExtra("DIFFICULTY", "difficult")
            startActivity(intent)
        }


    }
}