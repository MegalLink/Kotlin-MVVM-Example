package com.example.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor(){
        var quote:QuoteModel= QuoteModel(character = "Jeferson",quote = "Hola :D")
}