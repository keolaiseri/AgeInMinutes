package com.example.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {
            Toast.makeText(this,"Button Works", Toast.LENGTH_LONG).show() }




    }
}