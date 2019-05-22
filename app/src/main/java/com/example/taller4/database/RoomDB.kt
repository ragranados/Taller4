package com.example.taller4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taller4.DAOs.AutorDAO
import com.example.taller4.DAOs.EditorialDAO
import com.example.taller4.DAOs.LibroDAO
import com.example.taller4.DAOs.TagsDAO
import com.example.taller4.Entities.*

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
            context: Context
        ):RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context,RoomDB::class.java,"LibroDB")
                    .build()
                INSTANCE=instance
                return instance
            }
        }

    }
}