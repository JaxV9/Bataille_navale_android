package com.example.bataille_navale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class PlayerTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_two)

        val currentDifficulty = intent.extras?.getString("DIFFICULTY")
        val currentInstruction = intent.extras?.getString("INSTRUCTIONS")

        findViewById<TextView>(R.id.currentDifficulty).text = currentDifficulty
        findViewById<TextView>(R.id.playerTwoInstructions).text = currentInstruction

        val A1 = findViewById<Button>(R.id.A1)
        A1.setOnClickListener { findShip(A1) }
        val B1 = findViewById<Button>(R.id.B1)
        B1.setOnClickListener { findShip(B1) }
        val C1 = findViewById<Button>(R.id.C1)
        C1.setOnClickListener { findShip(C1) }
        val D1 = findViewById<Button>(R.id.D1)
        D1.setOnClickListener { findShip(D1) }
        val A2 = findViewById<Button>(R.id.A2)
        A2.setOnClickListener { findShip(A2) }
        val B2 = findViewById<Button>(R.id.B2)
        B2.setOnClickListener { findShip(B2) }
        val C2 = findViewById<Button>(R.id.C2)
        C2.setOnClickListener { findShip(C2) }
        val D2 = findViewById<Button>(R.id.D2)
        D2.setOnClickListener { findShip(D2) }
        val A3 = findViewById<Button>(R.id.A3)
        A3.setOnClickListener { findShip(A3) }
        val B3 = findViewById<Button>(R.id.B3)
        B3.setOnClickListener { findShip(B3) }
        val C3 = findViewById<Button>(R.id.C3)
        C3.setOnClickListener { findShip(C3) }
        val D3 = findViewById<Button>(R.id.D3)
        D3.setOnClickListener { findShip(D3) }
        val A4 = findViewById<Button>(R.id.A4)
        A4.setOnClickListener { findShip(A4) }
        val B4 = findViewById<Button>(R.id.B4)
        B4.setOnClickListener { findShip(B4) }
        val C4 = findViewById<Button>(R.id.C4)
        C4.setOnClickListener { findShip(C4) }
        val D4 = findViewById<Button>(R.id.D4)
        D4.setOnClickListener { findShip(D4) }
        val A5 = findViewById<Button>(R.id.A5)
        A5.setOnClickListener { findShip(A5) }
        val B5 = findViewById<Button>(R.id.B5)
        B5.setOnClickListener { findShip(B5) }
        val C5 = findViewById<Button>(R.id.C5)
        C5.setOnClickListener { findShip(C5) }
        val D5 = findViewById<Button>(R.id.D5)
        D5.setOnClickListener { findShip(D5) }
        val A6 = findViewById<Button>(R.id.A6)
        A6.setOnClickListener { findShip(A6) }
        val B6 = findViewById<Button>(R.id.B6)
        B6.setOnClickListener { findShip(B6) }
        val C6 = findViewById<Button>(R.id.C6)
        C6.setOnClickListener { findShip(C6) }
        val D6 = findViewById<Button>(R.id.D6)
        D6.setOnClickListener { findShip(D6) }

        if(currentDifficulty == "easy") {
            A5.visibility = View.INVISIBLE
            B5.visibility = View.INVISIBLE
            C5.visibility = View.INVISIBLE
            D5.visibility = View.INVISIBLE
            A6.visibility = View.INVISIBLE
            B6.visibility = View.INVISIBLE
            C6.visibility = View.INVISIBLE
            D6.visibility = View.INVISIBLE
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
    private fun findShip(button: Button){


        val playerOnePos = intent.extras?.getString("PLAYERONESHIP")
        val playerOnePosArray = arrayOf(convertLetterToNumber(playerOnePos!![0].toString()), playerOnePos.substring(1).toInt())

        val thisBtn = button.text.toString()
        val playerTwoSearchingArray = arrayOf(convertLetterToNumber(thisBtn[0].toString()), thisBtn.substring(1).toInt())

        val calcCloseLetter = (playerOnePosArray[0] - playerTwoSearchingArray[0])
        val calcCloseNumber = (playerOnePosArray[1] - playerTwoSearchingArray[1])
        val playerTwoCloseToShip = calcCloseLetter + calcCloseNumber

        val thisPlayerTwoCloseToShip = kotlin.math.abs(playerTwoCloseToShip)

        if(thisPlayerTwoCloseToShip == 0){
            findViewById<TextView>(R.id.playerTwoResult).text = "C'est gagné !"
            val intent = Intent(this, Score::class.java)
            intent.putExtra("ISWIN", "BRAVO ! You find the ship !")
            intent.putExtra("SCORE", "0")
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