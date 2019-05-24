package com.example.taller4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller4.Entities.Libro
import com.example.taller4.ViewModel.LibroViewModel
import com.example.taller4.adapters.BookAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var intent = Intent(this, NewBookActivity::class.java)

        startActivity(intent)*/

        //val libroViewModel= ViewModelProviders.of(this).get(LibroViewModel::class.java)

        val libro1 = LibroDTO("unooooo")
        val libro2 = LibroDTO("dos")
        val libro3 = LibroDTO("dos")

        val libros = ArrayList<LibroDTO>()
        libros.add(libro1)
        libros.add(libro2)
        libros.add(libro3)

        setUpView(libros)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun setUpView(libros: ArrayList<LibroDTO>){
        var viewManager = LinearLayoutManager(this)

        var viewAdapter = BookAdapter(this, {})

        viewAdapter.setBooks(libros)

        books_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun itemClickedPortrait(libro: LibroDTO){

    }

    fun itemClickedLandScape(libro: LibroDTO){

    }

    companion object {
        const val newBookActivityRequestCode = 1
    }
}
