package com.example.taller4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller4.Entities.Libro
import com.example.taller4.Entities.Tags
import com.example.taller4.ViewModel.LibroViewModel
import com.example.taller4.adapters.BookAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var libroViewModel: LibroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        libroViewModel = ViewModelProviders.of(this).get(LibroViewModel::class.java)

        val libros: LiveData<List<Libro>> = libroViewModel.getAllLibros()

        val librosObserver = Observer<List<Libro>>{ lista ->
            if(lista.size > 0){
                setUpView(getDTOList(lista))
            }else{
                Log.d("prueba","no hay tags")
            }
        }

        libros.observe(this,librosObserver)

        fab.setOnClickListener{view ->
            val intent = Intent(this@MainActivity, NewBookActivity::class.java)
            startActivityForResult(intent, newBookActivityRequestCode)
        }

    }

    fun getDTOList(libros: List<Libro>): ArrayList<LibroDTO>{
        val librosDTOList = ArrayList<LibroDTO>()

        for(i in libros){
            librosDTOList.add(LibroDTO(i.nombre, emptyList(),i.Edicion,i.Edicion,i.isbn,i.Sinopsis, emptyList()))
        }

        return librosDTOList
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newBookActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let {
                libroViewModel.insertLibro(Libro("N/A",
                        data?.getStringExtra(NewBookActivity.EXTRA_TITULO),
                        data?.getStringExtra(NewBookActivity.EXTRA_EDICION),
                        data?.getStringExtra(NewBookActivity.EXTRA_SINOPSIS),
                        data?.getStringExtra(NewBookActivity.EXTRA_ISBN),
                        false))
            }
        }

    }


    fun setUpView(libros: ArrayList<LibroDTO>){
        var viewManager = LinearLayoutManager(this)

        var viewAdapter = BookAdapter(this, {bookItem: LibroDTO -> itemClickedPortrait(bookItem)})

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
