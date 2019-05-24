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

    //-----------------------------Libros---------------------------------------------

    //obtener libro
    fun findLibroByName(name: String): LiveData<List<Libro>> = libroDao.findLibroByName(name)

    //obtener libros
    fun getAllLibros(): LiveData<List<Libro>> = libroDao.getAllLibros()

    //borrar libro
    fun deleteLibro(libro:Libro) = libroDao.deleteLibro(libro)

    //insertar libro
    @WorkerThread
    suspend fun insertLibro(libro:Libro) = libroDao.insertLibro(libro)

    //actualizar libro
    fun updateLibro(libro:Libro) = libroDao.updateLibro(libro)

    //--------------------------------------------------------------------------------

    //-------------------------------Autor--------------------------------------------

    //obtener autor
    fun getAutorByLibro(libroId: Int): LiveData<List<Autor>> = autorDao.getAutorByLibro(libroId)

    //obtener autores
    fun getAllAutores(): LiveData<List<Autor>> = autorDao.getallAutores()

    //borrar autor
    fun deleteAutor(autor:Autor) = autorDao.deleteAutor(autor)

    //insertar autor
    @WorkerThread
    suspend fun inertAutor(autor:Autor) = autorDao.insertAutor(autor)

    //actualizar autor
    fun updateAutor(autor:Autor) = autorDao.updateAutor(autor)

    //--------------------------------------------------------------------------------
    //-------------------------------Editorial----------------------------------------

    //obtener editorial
    fun getEditorialByLibro(libroId: Int): LiveData<List<Editorial>> = editorialDao.getEditorialByLibro(libroId)

    //obtener editoriales
    fun getAllEditoriales(): LiveData<List<Editorial>> = editorialDao.getallEditorial()

    //borrar editorial
    fun deleteEditorial(editorial:Editorial) = editorialDao.deleteEditorial(editorial)

    //insertar editorial
    @WorkerThread
    suspend fun insertEditorial(editorial:Editorial) = editorialDao.insertEditorial(editorial)

    //actualizar editorial
    fun updateEditorial(editorial:Editorial) = editorialDao.update(editorial)

    //--------------------------------------------------------------------------------
    //---------------------------------Tags-------------------------------------------

   //obtener tag
   fun getTagsByLibro(libroId: Int): LiveData<List<Tags>> = tagsDao.getTagsByLibro(libroId)

    //obtener tags
    fun getallTags(): LiveData<List<Tags>> = tagsDao.getallTags()

    //borrar tag
    fun deleteTag(tag:Tags) = tagsDao.deleteTag(tag)

    //insertar tag
    @WorkerThread
    suspend fun insertTag(tag:Tags) = tagsDao.insertTag(tag)

    //actualizar tags
    fun updateTags(tag:Tags) = tagsDao.update(tag)

    //------------------------------------------------------------------------------

}