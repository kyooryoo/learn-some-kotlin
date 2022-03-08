package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find roll button and listen on click to roll it
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            toast("Dice Rolled!")
            rollDice()
        }
    }

    /**
     * Toast some message to inform the user what happened.
     */
    private fun toast(msg: String) {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        toast.show()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new dice with 6 sides and roll it
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()
        // Update the screen with the dice roll
        val resultTextView1: TextView = findViewById(R.id.textView1)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView1.text = diceRoll1.toString()
        resultTextView2.text = diceRoll2.toString()
    }
}

/**
 * Create Dice class with sides attribute and roll method.
 */
class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}