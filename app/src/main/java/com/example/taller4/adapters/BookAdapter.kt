package com.example.taller4.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4.DAOs.LibroDAO
import com.example.taller4.Entities.Libro
import com.example.taller4.LibroDTO
import com.example.taller4.R
import com.example.taller4.models.Book
import kotlinx.android.synthetic.main.item_list.view.*

class BookAdapter (context: Context,val clickListener: (LibroDTO) -> Unit) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<LibroDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.item_list,parent,false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]

        holder.bind(current,clickListener)
    }

    fun setBooks(books: List<LibroDTO>){
        this.books = books
    }

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        fun bind(item: LibroDTO,clickListener: (LibroDTO) -> Unit) = with(itemView){
            item_view_book.text =item.titulo
        }

    }

}