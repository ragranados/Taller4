package com.example.taller4.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taller4.Entities.Libro

import com.example.taller4.R
import com.example.taller4.models.Book

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "Book"

class BookDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var book = Libro()

    private lateinit var fragmentView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_book_detail, container, false)
        fragmentView = view
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(book: Libro):BookDetailFragment{
            val newFragment = BookDetailFragment()

            newFragment.book = book

            return newFragment
        }

    }
}
