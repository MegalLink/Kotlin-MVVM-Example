package com.example.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    //Vinculamos el view model
    private val quoteViewModel:QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Inititalize with call to retrofit
        quoteViewModel.onCreate()
        //Observable
        quoteViewModel.quoteModel.observe(this, Observer {
            // Si nuestra variable quoteModel cambia hacemos algun cambio aqui
            binding.tvQuote.text=it.quote
            binding.tvCharacter.text=it.character
        })
        //Observable
        quoteViewModel.isLoading.observe(this, Observer {
            // Si nuestra variable isLoading cambia hacemos algo aqui
                binding.progressLoading.isVisible=it
        })

        binding.viewContainer.setOnClickListener{
            // hacemos que se actualice la variable quoteModel
            quoteViewModel.refreshQuote()
        }
    }
}