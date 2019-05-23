package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Autor")
data class Autor (
    val nombre: String
    //TODO No se puede guardar arrays en las bases de datos
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}