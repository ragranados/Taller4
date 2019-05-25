package com.example.taller4

import android.app.Activity
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.taller4.Entities.Autor
import kotlinx.android.synthetic.main.activity_new_book.*

class NewBookActivity : AppCompatActivity() {

    private lateinit var editTitulo: EditText
    private lateinit var editAutores: EditText
    private lateinit var editEdicion: EditText
    private lateinit var editEditorial: EditText
    private lateinit var editISBN: EditText
    private lateinit var editSinopsis: EditText
    private lateinit var editTags: EditText
    private lateinit var bAutores: Button
    private lateinit var bTags: Button

    private var autores = ArrayList<String>()
    private var tags = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)

        getEditTexts()
        initButtons()

        button.setOnClickListener{
            val replyIntent = Intent()

            //val bookTittle = editTitulo.text.toString()

            replyIntent.putExtra(EXTRA_TITULO, editTitulo.text.toString())
            replyIntent.putStringArrayListExtra(EXTRA_AUTORES,autores)
            replyIntent.putExtra(EXTRA_EDICION,editEdicion.text.toString())
            replyIntent.putExtra(EXTRA_EDICION,editEditorial.text.toString())
            replyIntent.putExtra(EXTRA_ISBN,editISBN.text.toString())
            replyIntent.putExtra(EXTRA_SINOPSIS, editSinopsis.text.toString())
            replyIntent.putExtra(EXTRA_TAGS,editSinopsis.text.toString())

            setResult(Activity.RESULT_OK,replyIntent)

            finish()
        }

    }

    fun getEditTexts(){
        editTitulo = findViewById(R.id.titulo)
        editAutores = findViewById(R.id.autores)
        editEdicion = findViewById(R.id.edicion)
        editEditorial = findViewById(R.id.editorial)
        editISBN = findViewById(R.id.isbn)
        editSinopsis = findViewById(R.id.sinopsis)
        editTags = findViewById(R.id.tags)
        bAutores = findViewById(R.id.add_autores)
        bTags = findViewById(R.id.add_tags)
    }

    fun initButtons(){
        bAutores.setOnClickListener{
            autores.add(editAutores.text.toString())

            editAutores.setText("")
        }

        bTags.setOnClickListener{
            tags.add(editTags.text.toString())

            editTags.setText("")
        }

    }

    companion object {
        const val EXTRA_TITULO = "titulo"
        const val EXTRA_AUTORES = "autores"
        const val EXTRA_EDICION = "edicion"
        const val EXTRA_EDITORIAL = "editorial"
        const val EXTRA_ISBN = "isbn"
        const val EXTRA_SINOPSIS = "sinopsis"
        const val EXTRA_TAGS = "tags"
    }
}
