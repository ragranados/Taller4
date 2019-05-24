package com.example.taller4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.taller4.ViewModel.LibroViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var intent = Intent(this, NewBookActivity::class.java)

        startActivity(intent)*/

        val libroViewModel= ViewModelProviders.of(this).get(LibroViewModel::class.java)
    }
}
