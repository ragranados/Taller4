package com.example.taller4.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4.R
import kotlinx.android.synthetic.main.item_list.view.*

class BookAdapter (context: Context) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.item_list,parent,false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]

        holder.bookViewItem.text = "" // TODO no funciona porque no existe entidad book
    }

    fun setBooks(books: List<Books>){
        this.books = books
    }

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val bookViewItem: TextView = itemView.findViewById(R.id.item_view_book)
    }

}