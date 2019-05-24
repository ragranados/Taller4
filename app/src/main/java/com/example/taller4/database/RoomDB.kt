package com.example.taller4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller4.DAOs.AutorDAO
import com.example.taller4.DAOs.EditorialDAO
import com.example.taller4.DAOs.LibroDAO
import com.example.taller4.DAOs.TagsDAO
import com.example.taller4.Entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Autor::class,
                      AutorxLibro::class,
                      Editorial::class,
                      EditorialxLibro::class,
                      Libro::class,
                      Tags::class,
                      TagsxLibro::class], version = 1, exportSchema = false)
public abstract class RoomDB:RoomDatabase(){

    abstract fun libroDao():LibroDAO
    abstract fun autorDao():AutorDAO
    abstract fun editorialDao():EditorialDAO
    abstract fun tagsDao():TagsDAO

    companion object{
        @Volatile
        private var INSTANCE:RoomDB?=null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ):RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context,RoomDB::class.java,"LibroDB")
                    .addCallback(LibroDBCallback(scope))
                    .build()
                INSTANCE=instance
                return instance
            }
        }

        private class LibroDBCallback(private val scope: CoroutineScope):RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase){
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDBLibro(database.libroDao())
                        populateDBAutor(database.autorDao())
                        populateDBEditorial(database.editorialDao())
                        populateDBTags(database.tagsDao())

                    }
                }
            }
        }

        suspend fun populateDBLibro(libroDAO: LibroDAO){
            libroDAO.deletall()
            var libro = Libro("IMG bonita", "Calculo", "segunda", "libro de calculo", "34sfgsfg", false)
            libroDAO.insertLibro(libro)
        }

        suspend fun populateDBAutor(autorDAO: AutorDAO){
            autorDAO.deleteAll()
            var autor = Autor("Juan")
            autorDAO.insertAutor(autor)
        }

        suspend fun populateDBEditorial(editorialDAO: EditorialDAO){
            editorialDAO.deleteAll()
            var editorial = Editorial("UCA")
            editorialDAO.insertEditorial(editorial)
        }

        suspend fun populateDBTags(tagsDAO: TagsDAO){
            tagsDAO.deleteAll()
            var tag = Tags("numeros")
            tagsDAO.insertTag(tag)
        }

    }
}