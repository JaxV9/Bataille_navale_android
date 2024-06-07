package com.example.bataille_navale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class PlayerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)

        val currentDifficulty = intent.extras?.getString("DIFFICULTY")
        val currentInstruction = intent.extras?.getString("INSTRUCTIONS")
        findViewById<TextView>(R.id.currentDifficulty).text = currentDifficulty
        findViewById<TextView>(R.id.playerOneInstructions).text = currentInstruction

        val A1 = findViewById<Button>(R.id.A1)
        A1.setOnClickListener { placeShip(A1, currentDifficulty.toString()) }
        val B1 = findViewById<Button>(R.id.B1)
        B1.setOnClickListener { placeShip(B1, currentDifficulty.toString()) }
        val C1 = findViewById<Button>(R.id.C1)
        C1.setOnClickListener { placeShip(C1, currentDifficulty.toString()) }
        val D1 = findViewById<Button>(R.id.D1)
        D1.setOnClickListener { placeShip(D1, currentDifficulty.toString()) }
        val A2 = findViewById<Button>(R.id.A2)
        A2.setOnClickListener { placeShip(A2, currentDifficulty.toString()) }
        val B2 = findViewById<Button>(R.id.B2)
        B2.setOnClickListener { placeShip(B2, currentDifficulty.toString()) }
        val C2 = findViewById<Button>(R.id.C2)
        C2.setOnClickListener { placeShip(C2, currentDifficulty.toString()) }
        val D2 = findViewById<Button>(R.id.D2)
        D2.setOnClickListener { placeShip(D2, currentDifficulty.toString()) }
        val A3 = findViewById<Button>(R.id.A3)
        A3.setOnClickListener { placeShip(A3, currentDifficulty.toString()) }
        val B3 = findViewById<Button>(R.id.B3)
        B3.setOnClickListener { placeShip(B3, currentDifficulty.toString()) }
        val C3 = findViewById<Button>(R.id.C3)
        C3.setOnClickListener { placeShip(C3, currentDifficulty.toString()) }
        val D3 = findViewById<Button>(R.id.D3)
        D3.setOnClickListener { placeShip(D3, currentDifficulty.toString()) }
        val A4 = findViewById<Button>(R.id.A4)
        A4.setOnClickListener { placeShip(A4, currentDifficulty.toString()) }
        val B4 = findViewById<Button>(R.id.B4)
        B4.setOnClickListener { placeShip(B4, currentDifficulty.toString()) }
        val C4 = findViewById<Button>(R.id.C4)
        C4.setOnClickListener { placeShip(C4, currentDifficulty.toString()) }
        val D4 = findViewById<Button>(R.id.D4)
        D4.setOnClickListener { placeShip(D4, currentDifficulty.toString()) }
        val A5 = findViewById<Button>(R.id.A5)
        A5.setOnClickListener { placeShip(A5, currentDifficulty.toString()) }
        val B5 = findViewById<Button>(R.id.B5)
        B5.setOnClickListener { placeShip(B5, currentDifficulty.toString()) }
        val C5 = findViewById<Button>(R.id.C5)
        C5.setOnClickListener { placeShip(C5, currentDifficulty.toString()) }
        val D5 = findViewById<Button>(R.id.D5)
        D5.setOnClickListener { placeShip(D5, currentDifficulty.toString()) }
        val A6 = findViewById<Button>(R.id.A6)
        A6.setOnClickListener { placeShip(A6, currentDifficulty.toString()) }
        val B6 = findViewById<Button>(R.id.B6)
        B6.setOnClickListener { placeShip(B6, currentDifficulty.toString()) }
        val C6 = findViewById<Button>(R.id.C6)
        C6.setOnClickListener { placeShip(C6, currentDifficulty.toString()) }
        val D6 = findViewById<Button>(R.id.D6)
        D6.setOnClickListener { placeShip(D6, currentDifficulty.toString()) }

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

    private fun placeShip(button: Button, currentDifficulty: String) {
            val intent = Intent(this, PlayerTwo::class.java)
            intent.putExtra("DIFFICULTY", currentDifficulty)
            intent.putExtra("INSTRUCTIONS", "Player 2, try to find the ship.")
            intent.putExtra("PLAYERONESHIP", button.text.toString())
            startActivity(intent)
    }
}