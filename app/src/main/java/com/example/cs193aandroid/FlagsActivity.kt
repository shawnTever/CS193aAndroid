package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FlagsActivity : AppCompatActivity() {
    private val COUNTRIES = listOf("Australia",
        "Brazil",
        "China",
        "Egypt",
        "France",
        "Germany",
        "Ghana",
        "Italy",
        "Japan",
        "Mexico",
        "Nepal",
        "Spain",
        "United Kingdom",
        "United States")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)
    }
}