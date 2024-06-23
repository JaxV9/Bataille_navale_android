package com.example.bataille_navale

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class PlayerTwo : AppCompatActivity() {

    private var currentAttempt = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_two)

        val currentDifficulty = intent.extras?.getString("DIFFICULTY")
        val currentInstruction = intent.extras?.getString("INSTRUCTIONS")

        findViewById<TextView>(R.id.currentDifficulty).text = currentDifficulty
        findViewById<TextView>(R.id.playerTwoInstructions).text = currentInstruction
        findViewById<TextView>(R.id.attempt).text = "Attempt: $currentAttempt"

        //Array des cellules
        val buttonIds = arrayOf(
            R.id.A1, R.id.B1,
            R.id.C1, R.id.D1,
            R.id.A2, R.id.B2,
            R.id.C2, R.id.D2,
            R.id.A3, R.id.B3,
            R.id.C3, R.id.D3,
            R.id.A4, R.id.B4,
            R.id.C4, R.id.D4,
            R.id.A5, R.id.B5,
            R.id.C5, R.id.D5,
            R.id.A6, R.id.B6,
            R.id.C6, R.id.D6)

        //J'appelle la fonction placeShip au clique d'une cellule
        for (id in buttonIds) {
            val button = findViewById<Button>(id)
            button.setOnClickListener { findShip(button) }
        }

        //Je cache des cellules en mode facile
        if(currentDifficulty == "Easy") {
            val buttonIds = arrayOf(
                R.id.A5, R.id.B5,
                R.id.C5, R.id.D5,
                R.id.A6, R.id.B6,
                R.id.C6, R.id.D6)

            for (id in buttonIds) {
                val button = findViewById<Button>(id)
                button.visibility = View.INVISIBLE
            }
        }
    }

    private fun convertLetterToNumber(letter: String): Int {
        return when (letter) {
            "A" -> 1
            "B" -> 2
            "C" -> 3
            "D" -> 4
            else -> 0
        }
    }
    private fun findShip(button: Button) {
        currentAttempt += 1
        findViewById<TextView>(R.id.attempt).text = "Attempt: $currentAttempt"
        val playerOnePos = intent.extras?.getString("PLAYERONESHIP")
        val playerOnePosArray = arrayOf(convertLetterToNumber(playerOnePos!![0].toString()), playerOnePos.substring(1).toInt())

        val thisBtn = button.text.toString()
        val playerTwoSearchingArray = arrayOf(convertLetterToNumber(thisBtn[0].toString()), thisBtn.substring(1).toInt())

        val calcCloseLetter = (playerOnePosArray[0] - playerTwoSearchingArray[0])
        val calcCloseNumber = (playerOnePosArray[1] - playerTwoSearchingArray[1])
        val playerTwoCloseToShip = calcCloseLetter + calcCloseNumber

        val thisPlayerTwoCloseToShip = kotlin.math.abs(playerTwoCloseToShip)
        button.setBackgroundColor(Color.parseColor("#5E86ED"))

        if(button.text == playerOnePos){
            findViewById<TextView>(R.id.playerTwoResult).text = "C'est gagné !"
            val intent = Intent(this, Score::class.java)
            intent.putExtra("ISWIN", "BRAVO ! You find the ship !")
            intent.putExtra("SCORE", currentAttempt.toString())
            startActivity(intent)
        }
        if(thisPlayerTwoCloseToShip == 1) {
            findViewById<TextView>(R.id.playerTwoResult).text = "Tu es proche"
        }
        if(thisPlayerTwoCloseToShip == 2) {
            findViewById<TextView>(R.id.playerTwoResult).text = "Pas encore"
        }
        if(thisPlayerTwoCloseToShip == 3) {
            findViewById<TextView>(R.id.playerTwoResult).text = "Tu es loin"
        }
        if(thisPlayerTwoCloseToShip >= 4) {
            findViewById<TextView>(R.id.playerTwoResult).text = "Tu es à côté de la plaque !"
        }
    }
}