package com.example.dhdesafiolayout.Model

import android.widget.ImageButton

 class Restaurante(var foto: Int, var titulo: String, var endereco: String, var horario:String) {
     override fun toString(): String {
         return "Restaurante(foto=$foto, titulo='$titulo', endereco='$endereco', horario='$horario')"
     }
 }
