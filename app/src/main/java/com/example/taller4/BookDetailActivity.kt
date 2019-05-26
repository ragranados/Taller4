package com.example.taller4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.taller4.fragments.BookDetailFragment

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        var bookInf: LibroDTO = intent?.extras?.getParcelable("libro")?:LibroDTO()

        initActivity(bookInf)

    }



    fun initActivity(libro: LibroDTO){
        var fragment =BookDetailFragment.newInstance(libro)

        changeFragment(R.id.content,fragment)
    }

    private fun changeFragment(id: Int, frag: Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }


}
