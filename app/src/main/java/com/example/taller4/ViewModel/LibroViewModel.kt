package com.example.taller4.ViewModel

import android.app.Application
import android.provider.DocumentsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller4.Entities.Autor
import com.example.taller4.Entities.Editorial
import com.example.taller4.Entities.Libro
import com.example.taller4.Entities.Tags
import com.example.taller4.RoomDB
import com.example.taller4.database.repositories.LibroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibroViewModel(app:Application):AndroidViewModel(app) {

    private var repository:LibroRepository?= null

    init {
        agregandoLibros()
    }

    fun agregandoLibros(){
        val libroDAO= RoomDB.getInstance(getApplication()).libroDao()
        val autorDAO= RoomDB.getInstance(getApplication()).autorDao()
        val editorialDAO= RoomDB.getInstance(getApplication()).editorialDao()
        val tagsDAO= RoomDB.getInstance(getApplication()).tagsDao()
        repository= LibroRepository(libroDAO, autorDAO,editorialDAO,tagsDAO)
    }

    fun insertLibro(libro:Libro)= viewModelScope.launch(Dispatchers.IO){
        repository!!.insertLibro(libro)
    }

    fun insertAutor(autor:Autor)= viewModelScope.launch(Dispatchers.IO){
        repository!!.inertAutor(autor)
    }

    fun insertEditorial(editorial: Editorial)= viewModelScope.launch(Dispatchers.IO){
        repository!!.insertEditorial(editorial)
    }
    fun insertTags(tags: Tags)= viewModelScope.launch(Dispatchers.IO){
        repository!!.insertTag(tags)
    }
kk
    fun getAllLibros():LiveData<List<Libro>> = repository!!.getAllLibros()
    fun getAllAutores():LiveData<List<Autor>> = repository!!.getAllAutores()
    fun getAllEditores():LiveData<List<Editorial>> = repository!!.getAllEditoriales()
    fun getAllTags():LiveData<List<Tags>> = repository!!.getAllTags()
}