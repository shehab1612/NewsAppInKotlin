package com.example.newsappinkotlin.APIServices

import com.google.gson.annotations.SerializedName

data class mySource (
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name :String
){
}