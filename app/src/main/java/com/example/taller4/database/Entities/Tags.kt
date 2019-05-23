package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tags")
data class Tags (
    val tag: List<String>
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}