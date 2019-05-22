package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "AutorxLibro",
        primaryKeys = arrayOf("autorId","libroId"),
        foreignKeys = arrayOf(
            ForeignKey(
                entity = Autor::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("autorId")),
            ForeignKey(
                entity = Libro::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("libroId")
            )
        )
    )
data class AutorxLibro (
    val autorId: Int,
    val libroId: Int
)