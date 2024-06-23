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

        //On récupère les propriétés de la vue du joueur 2
        val isWin = intent.extras?.getString("ISWIN")
        findViewById<TextView>(R.id.isWin).text = isWin
        val currentScore = intent.extras?.getString("SCORE")

        //Convertion de currentScore en int
        val currentScoreNumber = currentScore?.toInt() ?: 0

        //Changement d'orthographe si singulier ou pluriel, et on affiche le nombre de tentative
        if(currentScoreNumber == 1){

            findViewById<TextView>(R.id.score).text = "${currentScore} attempt"
        }
        if(currentScoreNumber > 1){
            findViewById<TextView>(R.id.score).text = "${currentScore} attempts"
        }

        //Bouton pour retourner à l'accueil
        findViewById<Button>(R.id.goHome).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}