package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Libro")
data class Libro (
    val nombre: String,
    val isbn: String,
    val favorito: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}