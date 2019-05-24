package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Libro")
data class Libro (
    val caratula: String = "N/A",
    val nombre: String = "N/A",
    val Edicion: String = "N/A",
    val Sinopsis: String = "N/A",
    val isbn: String = "N/A",
    val favorito: Boolean = false
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}