package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autor")
data class Autor (
    val nombre: String,
    val libros: ArrayList<String>
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}