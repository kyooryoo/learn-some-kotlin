package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    // use View Binding can greatly facilitate accessing views
    // View Binding is enabled in module level *build.gradle* file
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // update the following line of default code to *binding.root*
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        // handle input service fee of null gracefully
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        // get tip percentage value from service quality options
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        // calculate tip and round up if selected
        var tip = tipPercentage * cost
        if (binding.roundUpSwitchCompat.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        displayTip(tip)
    }

    // use specific function to eliminate duplicated code for tip display
    private fun displayTip(tip: Double) {
        // use system function to format currency value dynamically
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        // check string *tip_amount* for detail of string formatting
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}