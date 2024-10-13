package com.example.linearlayout

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Recogemos el botón y los textos de los EditText
        val buttonMostrar: Button = findViewById(R.id.button)
        val nombre = findViewById<View>(R.id.editTextText) as EditText


        buttonMostrar.setOnClickListener {
            val nombreText:String = nombre.text.toString()
            Toast.makeText(applicationContext, "El nombre introducido es: $nombreText", Toast.LENGTH_SHORT).show()

        }
    }
}