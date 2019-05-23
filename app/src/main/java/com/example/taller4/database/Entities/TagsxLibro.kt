package com.example.taller4.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "TagsxLibro",
        primaryKeys = arrayOf("tagId", "libroId"),
        foreignKeys = arrayOf(
            ForeignKey(
                entity = Tags::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("tagId")),
            ForeignKey(
                entity = Libro::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("libroId"))
        )
)
data class TagsxLibro (
    val tagId: Int,
    val libroId: Int
)