package com.example.taller4.DAOs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taller4.Entities.Autor

@Dao
interface AutorDAO {

    @Query("SELECT * FROM Autor")
    fun getallAutores(): LiveData<List<Autor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAutor(autor: Autor)

    @Update
    fun updateAutor(autor: Autor)

    @Delete
    fun deleteAutor(autor: Autor)
}