package com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

//Serialized name is from retrofit its not needed if the name of the atribute is the same in api
data class QuoteModel (
    @SerializedName ("quote")val quote:String,
    @SerializedName ("character") val character:String,
    @SerializedName ("image") val image:String="",
    @SerializedName ("characterDirection") val characterDirection:String=""
    )