package com.example.verfuturo

class Oraculo(val mes: Int) {

    private var mesTexto: String = ""

    public fun getMes(): String{
        when (mes){
            1 -> mesTexto = "ENERO"
            2 -> mesTexto = "FEBRERO"
            3 -> mesTexto = "MARZO"
            4 -> mesTexto = "ABRIL"
            5 -> mesTexto = "MAYO"
            6 -> mesTexto = "JUNIO"
            7 -> mesTexto = "JULIO"
            8 -> mesTexto = "AGOSTO"
            9 -> mesTexto = "SEPTIEMBRE"
            10 -> mesTexto = "OCTUBRE"
            11 -> mesTexto = "NOVIEMBRE"
            12 -> mesTexto = "DICIEMBRE"
        }
        return mesTexto
    }

}