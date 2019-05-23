package com.example.taller4.database.repositories

import androidx.lifecycle.LiveData
import com.example.taller4.DAOs.AutorDAO
import com.example.taller4.DAOs.EditorialDAO
import com.example.taller4.DAOs.LibroDAO
import com.example.taller4.DAOs.TagsDAO
import com.example.taller4.Entities.Autor
import com.example.taller4.Entities.Editorial
import com.example.taller4.Entities.Libro
import com.example.taller4.Entities.Tags

class LibroRepository(private val libroDao:LibroDAO,
                      private val autorDao: AutorDAO,
                      private val editorialDao:EditorialDAO,
                      private val tagsDao: TagsDAO) {

    //obtener libros
    fun getAllLibros(): LiveData<List<Libro>> = libroDao.getAllLibros()

    //obtener autores
    fun getAllAutores(): LiveData<List<Autor>> = autorDao.getallAutores()

    //obtener editorial
    fun getAllEditoriales(): LiveData<List<Editorial>> = editorialDao.getallEditorial()

    //obtener tags
    fun getAllTags(): LiveData<List<Tags>> = tagsDao.getallTags()



}