package com.example.taller4

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller4.Entities.Autor
import com.example.taller4.Entities.Editorial
import com.example.taller4.Entities.Libro
import com.example.taller4.Entities.Tags
import com.example.taller4.ViewModel.LibroViewModel
import com.example.taller4.adapters.BookAdapter
import com.example.taller4.fragments.BookDetailFragment
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
            librosDTOList.add(LibroDTO(i.nombre, libroViewModel.findAutorByLibro(i.id.toInt()).value,i.Edicion,i.isbn,i.Sinopsis, emptyList()))
        }

        return librosDTOList
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newBookActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.extras?.let {
                libroViewModel.insertLibro(Libro("N/A",
                        it.getString(NewBookActivity.EXTRA_TITULO),
                        it.getString(NewBookActivity.EXTRA_EDICION),
                        it.getString(NewBookActivity.EXTRA_SINOPSIS),
                        it.getString(NewBookActivity.EXTRA_ISBN),
                        false))
            }

            data?.extras?.getStringArrayList(NewBookActivity.EXTRA_AUTORES)?.forEach { autor ->
                libroViewModel.insertAutor(Autor(autor))
            }

            data?.extras?.getStringArrayList(NewBookActivity.EXTRA_EDITORIAL)?.forEach { editorial->
                libroViewModel.insertEditorial(Editorial(editorial))
            }

            data?.extras?.getStringArrayList(NewBookActivity.EXTRA_TAGS)?.forEach {tag->
                libroViewModel.insertTags(Tags(tag))
            }

            //libroViewModel.findAutorByLibro()
        }

    }

    fun setUpView(libros: ArrayList<LibroDTO>){
        var viewManager = LinearLayoutManager(this)
        lateinit var viewAdapter: BookAdapter


        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            viewAdapter = BookAdapter(this, {bookItem: LibroDTO -> itemClickedPortrait(bookItem)})
        }else{
            var contentFragment : BookDetailFragment = BookDetailFragment.newInstance(LibroDTO())
            viewAdapter =BookAdapter(this, {bookItem: LibroDTO -> itemClickedLandScape(bookItem)})
            changeFragment(R.id.land_book_detail,contentFragment)
        }

        viewAdapter.setBooks(libros)

        books_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    fun itemClickedPortrait(libro: LibroDTO){

        val bookBundle = Bundle()
        bookBundle.putParcelable("libro",libro)

        startActivity(Intent(this, BookDetailActivity::class.java).putExtras(bookBundle))

    }

    fun itemClickedLandScape(libro: LibroDTO){
        var contentFragment : BookDetailFragment = BookDetailFragment.newInstance(libro)
        changeFragment(R.id.land_book_detail,contentFragment)
    }

    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }

    companion object {
        const val newBookActivityRequestCode = 1
    }
}
