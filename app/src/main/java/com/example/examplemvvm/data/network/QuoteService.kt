package com.example.examplemvvm.data.network

import android.util.Log
import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit =RetrofitHelper.getRetrofit()
    //usamos suspend por que usamos corutinas
    suspend fun getQuote():QuoteModel{
        //WithContext to use coroutines
        return withContext(Dispatchers.IO){
            val response= retrofit.create(SimpsonQuoteApiClient::class.java).getAllQuotes()
            Log.i("QuoteService",response.body().toString())
            //TODO add logic when body is empty or bad response
            response.body()?.get(0)!!
        }

    }
}