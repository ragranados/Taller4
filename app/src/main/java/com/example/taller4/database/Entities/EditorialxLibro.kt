package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "EditorialxLibro",
        primaryKeys = arrayOf("editorialId", "libroId"),
        foreignKeys = arrayOf(
            ForeignKey(
                entity = Editorial::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("editorialId")),
            ForeignKey(
                entity = Libro::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("libroId"))
        )
)
data class EditorialxLibro (
    val edotorialId: Int,
    val libroId: Int
)