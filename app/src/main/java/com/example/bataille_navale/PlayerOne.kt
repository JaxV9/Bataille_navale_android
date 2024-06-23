package com.example.bataille_navale

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class PlayerOne : AppCompatActivity() {

    private var currentChoice = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)
        //J'affiche la bonne difficulté
        val currentDifficulty = intent.extras?.getString("DIFFICULTY")
        //J'affiche les instructions correspondant au joueur
        val currentInstruction = intent.extras?.getString("INSTRUCTIONS")
        findViewById<TextView>(R.id.currentDifficulty).text = currentDifficulty
        findViewById<TextView>(R.id.playerOneInstructions).text = currentInstruction
        findViewById<TextView>(R.id.currentChoice).text = "Your ship in: $currentChoice"
        //Ce bouton sert à confirmer le choix du joueur 1
        val btnChoice = findViewById<Button>(R.id.confirmChoicePlayerOne)

        btnChoice.setOnClickListener {
            val intent = Intent(this, PlayerTwo::class.java)
            intent.putExtra("DIFFICULTY", currentDifficulty)
            intent.putExtra("INSTRUCTIONS", "Player 2, try to find the ship.")
            intent.putExtra("PLAYERONESHIP", currentChoice)
            startActivity(intent)
        }

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
            button.setOnClickListener { placeShip(button) }
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

        //Le temps que je n'ai pas fait de choix, le bouton de confirmation est invisible
        if(currentChoice == "") {
            btnChoice.visibility = View.INVISIBLE
        }

    }

    private fun placeShip(button: Button) {
        if(button.text !== ""){
            findViewById<TextView>(R.id.currentChoice).text = "Your ship in: ${button.text}"
            currentChoice = button.text.toString()
            findViewById<Button>(R.id.confirmChoicePlayerOne).visibility = View.VISIBLE
        }
    }

}