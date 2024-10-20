package com.example.sqlliteviewsactivity

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ClienteSQLite (context:Context) : SQLiteOpenHelper(context,"Clientes.db",null,1) {
    override fun onCreate(db: SQLiteDatabase) {

        //Crear una tabla Clientes
        val createTableQuery = """
            CREATE TABLE clientes(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                dni TEXT NOT NULL
            )""".trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //Eliminar la tabla Clientes si existe y volver a crearla
        db.execSQL("DROP TABLE IF EXISTS clientes")
        onCreate(db)
    }

    //OPERACIONES CRUD

    fun insert(nuevoCliente: Cliente): Long {
        /*Método de la clase SQLiteOpenHelper en Android que devulve una instancia de SQLiteDatabase que permite realizar
        * operaciones de escritura en la base de datos asociada
        */
        val db = getWritableDatabase()

        /***
         * Clase proporcionada por Android que se utiliza para almacenar un conjunto de paraes clave-valor
         */
        val values = ContentValues()
        values.put("nombre", nuevoCliente.nombre)
        values.put("dni", nuevoCliente.dni)

        val newId = db.insert("clientes", null, values)
        db.close()
        return newId
    }


    fun read(idCliente: Long): Cliente {

        val db = getReadableDatabase()
        val selectQuery = "SELECT * FROM clientes WHERE id = ?"
        val cursor: Cursor = db.rawQuery(selectQuery, arrayOf(idCliente.toString()))
        //Lo creamos fuera, por si no entra en la condición, devolvemos un cliente vacío
        var cliente = Cliente("", "")
        if (cursor.moveToFirst()) {
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val dni = cursor.getString(cursor.getColumnIndexOrThrow("dni"))
            cliente = Cliente(nombre, dni)
        }
        cursor.close()
        db.close()
        return cliente

    }


    fun update(idCliente: Long, cliente: Cliente): Int {
        val db = getWritableDatabase()

        val values = ContentValues()
        values.put("nombre", cliente.nombre)
        values.put("dni", cliente.dni)

        val affectRows = db.update("clientes", values, "id = ?", arrayOf(idCliente.toString()))
        db.close()
        return affectRows
    }


    fun delete(idCliente: Long): Int {
        val db = getWritableDatabase()

        val affectRows = db.delete("clientes", "id = ?", arrayOf(idCliente.toString()))
        db.close()

        return affectRows
    }

    fun getNumeroClientes(): Int {
        val db = getReadableDatabase()
        val selectQuery = "SELECT count(*) as numClientes FROM clientes"

        val cursor: Cursor = db.rawQuery(selectQuery, null)
        var num = -1

        if (cursor.moveToFirst()) {
            num = cursor.getInt(cursor.getColumnIndexOrThrow("numClientes"))
        }
        cursor.close()
        db.close()
        return num
    }

    fun getListadoClientes(): List<Cliente> {
        val clienteList = mutableListOf<Cliente>()
        val db = getReadableDatabase()
        val selectQuery = "SELECT * FROM clientes ORDER BY dni DESC"
        val cursor: Cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val dni = cursor.getString(cursor.getColumnIndexOrThrow("dni"))
                val cliente = Cliente(nombre, dni)
                clienteList.add(cliente)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return clienteList
    }


}