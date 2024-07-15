package com.example.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var totalFood = 0
    private var totalEntertainment = 0
    private var totalTransportation = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categorySpinner: Spinner = findViewById(R.id.spinnerCategory)
        val addButton: Button = findViewById(R.id.btnAddExpense)
        val amountEditText: EditText = findViewById(R.id.etAmount)
        val resultTextView: TextView = findViewById(R.id.tvResult)

        val categories = arrayOf("Food", "Entertainment", "Transportation")
        categorySpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories)

        addButton.setOnClickListener {
            val selectedCategory = categorySpinner.selectedItem.toString()
            val amount = amountEditText.text.toString().toIntOrNull()

            if (amount != null) {
                when (selectedCategory) {
                    "Food" -> totalFood += amount
                    "Entertainment" -> totalEntertainment += amount
                    "Transportation" -> totalTransportation += amount
                }
                updateResultTextView(resultTextView)
            } else {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            }
        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Handle item selection if needed
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case when nothing is selected
            }
        }
    }

    private fun updateResultTextView(textView: TextView) {
        textView.text = "Food: $totalFood\nEntertainment: $totalEntertainment\nTransportation: $totalTransportation"
    }
}
