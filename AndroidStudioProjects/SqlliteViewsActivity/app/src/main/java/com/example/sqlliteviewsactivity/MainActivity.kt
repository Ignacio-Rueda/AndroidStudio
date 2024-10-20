package com.example.sqlliteviewsactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val c1 = Cliente ("Juan Díaz","12345678A")
        val c2 = Cliente("Paco Gómez","87654321B")
        val c3 = Cliente ("Lucía Castro","11111111P")

        val bbddClientes = ClienteSQLite(this)
        bbddClientes.insert(c1)
        bbddClientes.insert(c2)
        bbddClientes.insert(c3)

        //Mostramos los clientes
        val listaCliente = bbddClientes.getListadoClientes()
        for(cliente in listaCliente){
            Log.i("MyActivity","Nombre: ${cliente.nombre} DNI: ${cliente.dni}")
        }

    }
}