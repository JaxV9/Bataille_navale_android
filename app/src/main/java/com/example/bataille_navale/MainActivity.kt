package com.example.bataille_navale

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentOpponent = ""
    var currentDifficulty = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Je récupère les boutons pour choisir l'adversaire
        val iaBtn = findViewById<Button>(R.id.AI)
        val j1VsJ2 = findViewById<Button>(R.id.j1VsJ2)

        //Choix de l'adversaire en mettant à jour currentOpponent
        iaBtn.setOnClickListener {
            it.setBackgroundColor(Color.parseColor("#5E86ED"))
            j1VsJ2.setBackgroundColor(Color.parseColor("#CBCBCB"))
            currentOpponent = iaBtn.text.toString()
            updateNewGameVisibility(iaBtn)
        }
        j1VsJ2.setOnClickListener {
            it.setBackgroundColor(Color.parseColor("#5E86ED"))
            iaBtn.setBackgroundColor(Color.parseColor("#CBCBCB"))
            currentOpponent = j1VsJ2.text.toString()
            updateNewGameVisibility(j1VsJ2)
        }


        //Je récupère les boutons pour choisir la difficulté
        val easyBtn = findViewById<Button>(R.id.buttonEasy)
        val difficultBtn = findViewById<Button>(R.id.buttonDifficult)

        easyBtn.setOnClickListener {
            it.setBackgroundColor(Color.parseColor("#5E86ED"))
            difficultBtn.setBackgroundColor(Color.parseColor("#CBCBCB"))
            currentDifficulty = easyBtn.text.toString()
            updateNewGameVisibility(easyBtn)
        }
        difficultBtn.setOnClickListener {
            it.setBackgroundColor(Color.parseColor("#5E86ED"))
            easyBtn.setBackgroundColor(Color.parseColor("#CBCBCB"))
            currentDifficulty = difficultBtn.text.toString()
            updateNewGameVisibility(difficultBtn)
        }

        //Je récupère le bouton de confirmation
        val newGame = findViewById<Button>(R.id.newGame)
        if(currentOpponent == "" && currentDifficulty == ""){
            newGame.visibility = View.INVISIBLE
        }

        newGame.setOnClickListener {

            if(currentOpponent == "J1 vs J2"){
                val intent = Intent(this, PlayerOne::class.java)
                intent.putExtra("DIFFICULTY", currentDifficulty)
                intent.putExtra("INSTRUCTIONS", "Player 1, place your ship on the grid.")
                startActivity(intent)
            }

            if(currentOpponent == "AI"){
                val currentChoice = ""
                val intent = Intent(this, PlayerTwo::class.java)
                intent.putExtra("DIFFICULTY", currentDifficulty)
                intent.putExtra("INSTRUCTIONS", "Player 2, try to find the ship placed by the AI.")
                intent.putExtra("PLAYERONESHIP", AIChoiceGenerated(currentDifficulty))
                startActivity(intent)
            }

        }


    }

    //Je rends disponible le bouton NewGame quand le joueur a choisi l'adversaire et la difficulté
    private fun updateNewGameVisibility(button: Button) {
        if(currentOpponent !== "" && currentDifficulty !== ""){
            val newGame = findViewById<Button>(R.id.newGame)
            newGame.visibility = View.VISIBLE
        }
    }

    private fun AIChoiceGenerated(difficulty: String):String {

        var randomChoice = ""
        if(difficulty == "Easy") {
            val choices = arrayOf(
                "A1", "B1",
                "C1", "D1",
                "A2", "B2",
                "C2", "D2",
                "A3", "B3",
                "C3", "D3",
                "A4", "B4",
                "C4", "D4"
            )
            randomChoice = choices.random().toString()
        }
        if(difficulty == "Difficult"){
            val choices = arrayOf(
                "A1", "B1",
                "C1", "D1",
                "A2", "B2",
                "C2", "D2",
                "A3", "B3",
                "C3", "D3",
                "A4", "B4",
                "C4", "D4",
                "A5", "B5",
                "C5", "D5",
                "A6", "B6",
                "C6", "D6"
            )
            randomChoice = choices.random()
        }
        return randomChoice
    }
}