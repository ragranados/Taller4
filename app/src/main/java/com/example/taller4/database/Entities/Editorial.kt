package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Editorial")
data class Editorial (
    val nombre: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}