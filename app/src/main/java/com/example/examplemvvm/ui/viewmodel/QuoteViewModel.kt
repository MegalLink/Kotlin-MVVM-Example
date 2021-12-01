package com.example.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.domain.GetQuote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
//View Model al cual podemos injectar dependencias en el constructor
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuote: GetQuote
) :ViewModel(){
    //creamos una variable que va a ser observada
    val quoteModel= MutableLiveData<QuoteModel>()
    val isLoading=MutableLiveData<Boolean>()
    fun onCreate(){
        refreshQuote()
    }

    fun refreshQuote(){
        //Corutina que se controla automaticamente, si una actividad muere se termina automaticamente
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuote()
            //TODO check if is not empty
            quoteModel.postValue(result!!)
            isLoading.postValue(false)
        }
    }

}