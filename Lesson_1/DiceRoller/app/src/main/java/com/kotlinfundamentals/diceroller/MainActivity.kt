package com.kotlinfundamentals.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countUpButton = findViewById<Button>(R.id.countup_button)
        countUpButton.setOnClickListener { countUp() }
        resultText = findViewById<TextView>(R.id.result_text)
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }

    //Code challenge
    private fun countUp() {
        //Check current text content
        val currentText = resultText.text.toString()
        try {
            //Parse integer & count up
            var currentNumber = currentText.toInt()
            if (currentNumber != 6) currentNumber ++
            resultText.text = currentNumber.toString()
        }catch (e: NumberFormatException) {
            //No Int parsing available
            resultText.text = "1"
        }
    }

}