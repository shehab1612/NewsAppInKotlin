package com.example.newsappinkotlin.APIServices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    val baseurl="https://newsapi.org/v2/"
    var retrofit:Retrofit? = null

    fun getRetrofitClient(): Retrofit{
        if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }

}