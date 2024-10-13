package com.example.verfuturo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class verFuturo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_futuro)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        val botonVerfuturo: Button = findViewById<Button>(R.id.buttonVerFuturo)
        val mostrarResultado: TextView = findViewById<TextView>(R.id.txtVerFuturo)

        botonVerfuturo.setOnClickListener(object : View.OnClickListener{
            override fun onClick(V: View) {
                finish()
            }

        })


        //-1 es el valor por defecto
        val mesNacimiento = intent.getIntExtra("mes",-1)
        val oraculo: Oraculo = Oraculo(mesNacimiento)
        val mesTexto = oraculo.getMes()
        mostrarResultado.text = "El mes en el que nació fue = $mesTexto"
    }
}