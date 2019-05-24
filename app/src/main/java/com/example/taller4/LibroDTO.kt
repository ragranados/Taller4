package com.example.taller4

import androidx.lifecycle.LiveData

class LibroDTO (
    val titulo: String = "N/A",
    val autores: List<String> = emptyList(),
    val edicion: String = "N/A",
    val editorial: String = "N/A",
    val isbn: String = "N/A",
    val sinopsis: String = "N/A",
    val tags: List<String> = emptyList()
)