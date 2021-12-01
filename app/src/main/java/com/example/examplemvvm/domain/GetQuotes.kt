package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel

//logica del negocio, casos de uso
class GetQuote {
    private val repository =QuoteRepository()
    suspend operator fun invoke ():QuoteModel?{
        return repository.getQuote()
    }
}