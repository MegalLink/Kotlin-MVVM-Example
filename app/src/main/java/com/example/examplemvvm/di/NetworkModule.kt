package com.example.examplemvvm.di

import com.example.examplemvvm.data.network.SimpsonQuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Para proveer dependencias de librerias externas o que no se les pueda asignar inject
@Module
@InstallIn(SingletonComponent::class)//cuanto tiempo dura la instancia
object NetworkModule {

    @Singleton //Una unica instancia de retrofrit sino se le pone crea otra instancia cada vez
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://thesimpsonsquoteapi.glitch.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton //Una unica instancia de retrofrit sino se le pone crea otra instancia cada vez
    @Provides
    fun provideQuoteApiClient(retrofit:Retrofit):SimpsonQuoteApiClient{ //Podemos enviar retrofit como parametro por que ya esta injectado anteriormente
        return retrofit.create(SimpsonQuoteApiClient::class.java)
    }
}

//Aplication -> @Singleton
//ViewModel -> @ActivityRetainedScope
//Activity -> @ActivityScoped
//Fragment -> @FragmentScoped
//View -> @ViewScoped
//Service -> @ServiceScoped