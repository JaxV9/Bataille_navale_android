package com.example.bataille_navale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Je récupère les boutons pour choisir la difficulté
        val easyBtn = findViewById<Button>(R.id.buttonEasy)
        val difficultBtn = findViewById<Button>(R.id.buttonDifficult)

        //Si le mode facile est choisi, alors je passe les bons paramètres à la prochaine vue
        easyBtn.setOnClickListener {
            val intent = Intent(this, PlayerOne::class.java)
            intent.putExtra("DIFFICULTY", "easy")
            intent.putExtra("INSTRUCTIONS", "Player 1, place your ship on the grid.")
            startActivity(intent)
        }
        //Si le mode difficile est choisi, alors je passe les bons paramètres à la prochaine vue
        difficultBtn.setOnClickListener {
            val intent = Intent(this, PlayerOne::class.java)
            intent.putExtra("DIFFICULTY", "difficult")
            intent.putExtra("INSTRUCTIONS", "Player 1, place your ship on the grid.")
            startActivity(intent)
        }


    }
}