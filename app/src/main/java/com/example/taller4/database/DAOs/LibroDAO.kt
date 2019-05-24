package com.example.taller4.DAOs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taller4.Entities.Libro

@Dao
interface LibroDAO {

    @Query("SELECT * FROM Libro")
    fun getAllLibros():LiveData<List<Libro>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibro(libro: Libro)

    @Update
    fun updateLibro(libro: Libro)

    @Query("SELECT * FROM Libro WHERE nombre LIKE :name")
    fun findLibroByName(name: String): List<Libro>

    @Delete
    fun deleteLibro(libro: Libro)

}