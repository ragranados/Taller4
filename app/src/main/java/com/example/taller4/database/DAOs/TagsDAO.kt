package com.example.taller4.DAOs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taller4.Entities.Libro
import com.example.taller4.Entities.Tags

@Dao
interface TagsDAO {

    @Query("SELECT * FROM Tags")
    fun getallTags(): LiveData<List<Tags>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(tag: Tags)

    @Update
    fun update(tag: Tags)

    @Delete
    fun deleteTag(tag: Tags)

    @Query("SELECT * FROM Tags\n" +
            "INNER JOIN TagsxLibro\n" +
            "ON Tags.id=TagsxLibro.tagId\n" +
            "WHERE TagsxLibro.libroId = :libroId")
    fun getTagsByLibro(libroId: Int): List<Tags>
}