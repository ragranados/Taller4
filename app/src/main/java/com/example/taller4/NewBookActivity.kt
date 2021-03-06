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
    private lateinit var bEditoriales: Button

    private var autores = ArrayList<String>()
    private var tags = ArrayList<String>()
    private var editoriales = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)

        getEditTexts()
        initButtons()

        button.setOnClickListener{
            val replyIntent = Intent()

            val reply = Bundle()
            //reply.putStringArrayList()

            //val bookTittle = editTitulo.text.toString()

            //if(editTitulo.text.isNotEmpty() && autores.isNotEmpty() && editEdicion.text.isNotEmpty() && editTitulo.text.isNotEmpty()){
                reply.putString(EXTRA_TITULO, editTitulo.text.toString())
                reply.putStringArrayList(EXTRA_AUTORES,autores)
                reply.putString(EXTRA_EDICION,editEdicion.text.toString())
                reply.putStringArrayList(EXTRA_EDITORIAL,editoriales)
                reply.putString(EXTRA_ISBN,editISBN.text.toString())
                reply.putString(EXTRA_SINOPSIS, editSinopsis.text.toString())
                reply.putStringArrayList(EXTRA_TAGS,tags)
            //}

            replyIntent.putExtras(reply)



            setResult(Activity.RESULT_OK,replyIntent)

            finish()
        }

    }

    fun getEditTexts(){
        editTitulo = findViewById(R.id.titulo)
        //editEditorial.setText("N/A")
        editAutores = findViewById(R.id.autores)
        editEdicion = findViewById(R.id.edicion)
        editEditorial = findViewById(R.id.editoriales)
        editISBN = findViewById(R.id.isbn)
        editSinopsis = findViewById(R.id.sinopsis)
        editTags = findViewById(R.id.tags)
        bAutores = findViewById(R.id.add_autores)
        bTags = findViewById(R.id.add_tags)
        bEditoriales = findViewById(R.id.add_editoriales)

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

        bEditoriales.setOnClickListener{
            editoriales.add(editEditorial.text.toString())

            editEditorial.setText("")
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
