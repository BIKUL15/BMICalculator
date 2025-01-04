package com.example.bmicalculator // atau com.example.kalkulatorbmi sesuai dengan nama proyek Anda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightInput = findViewById<EditText>(R.id.weightInput)
        val heightInput = findViewById<EditText>(R.id.heightInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if (weight != null && height != null && height > 0) {
                val bmi = weight / (height * height)
                val bmiCategory = when {
                    bmi < 18.5 -> "Underweight"
                    bmi in 18.5..24.9 -> "Normal weight"
                    bmi in 25.0..29.9 -> "Overweight"
                    else -> "Obesity"
                }
                resultText.text = "Your BMI: %.2f\nCategory: %s".format(bmi, bmiCategory)
            } else {
                Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
