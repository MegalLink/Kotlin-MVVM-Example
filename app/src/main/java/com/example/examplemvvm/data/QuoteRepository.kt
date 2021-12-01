package com.example.examplemvvm.data

import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.data.network.QuoteService

class QuoteRepository {
    private val api= QuoteService()
    suspend fun getQuote():QuoteModel{
        val response=api.getQuote()
        QuoteProvider.quote=response
        return response
    }
}