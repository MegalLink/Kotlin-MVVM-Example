package com.example.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    //Vinculamos el view model
    private val quoteViewModel:QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer {
            // Si nuestra variable quoteModel cambia hacemos algun cambio aqui
            binding.tvQuote.text=it.quote
            binding.tvAuthor.text=it.author
        })

        binding.viewContainer.setOnClickListener{
            // hacemos que se actualice la variable quoteModel
            quoteViewModel.randomQuote()
        }
    }
}