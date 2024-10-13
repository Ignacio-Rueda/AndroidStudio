package com.example.verfuturo

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        val boton: Button = findViewById<Button>(R.id.button1)
        val entradaTxt: EditText = findViewById<EditText>(R.id.editText1)
        val calendario: DatePicker = findViewById<DatePicker>(R.id.datePicker1)

        boton.setOnClickListener(){
            val texto = entradaTxt.text
            val dia = calendario.dayOfMonth
            val mes = calendario.month + 1
            val anio = calendario.year
            Toast.makeText(this, "$dia / $mes / $anio",Toast.LENGTH_LONG).show()

            //Para realizar el envío de información de una activity a otra
            val intentFuturo = Intent(this,verFuturo::class.java)

            intentFuturo.putExtra("mes",mes)

            startActivity(intentFuturo)

        }


    }
}