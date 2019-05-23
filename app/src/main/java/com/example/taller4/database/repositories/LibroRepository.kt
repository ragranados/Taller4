package com.example.taller4.database.repositories

import androidx.annotation.WorkerThread
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

    //borrar libro
    fun deleteLibro(libro:Libro) = libroDao.deleteLibro(libro)

    //borrar autor
    fun deleteAutor(autor:Autor) = autorDao.deleteAutor(autor)

    //borrar editorial
    fun deleteEditorial(editorial:Editorial) = editorialDao.deleteEditorial(editorial)

    //borrar tag
    fun deleteTag(tag:Tags) = tagsDao.deleteTag(tag)

    //insertar libro
    @WorkerThread
    suspend fun insertLibro(libro:Libro) = libroDao.insertLibro(libro)

    //insertar autor
    @WorkerThread
    suspend fun inertAutor(autor:Autor) = autorDao.insertAutor(autor)

    //insertar editorial
    @WorkerThread
    suspend fun insertEditorial(editorial:Editorial) = editorialDao.insertEditorial(editorial)

    //insertar tag
    @WorkerThread
    suspend fun insertTag(tag:Tags) = tagsDao.insertTag(tag)

    //actualizar libro
    fun updateLibro(libro:Libro) = libroDao.updateLibro(libro)

    //actualizar autor
    fun updateAutor(autor:Autor) = autorDao.updateAutor(autor)

    //actualizar editorial
    fun updateEditorial(editorial:Editorial) = editorialDao.update(editorial)

    //actualizar tags
    fun updateTags(tag:Tags) = tagsDao.update(tag)

}