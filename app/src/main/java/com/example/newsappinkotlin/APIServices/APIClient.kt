package com.example.newsappinkotlin.APIServices

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    var service:ApiService
    val baseurl="https://newsapi.org/v2/"

    init {
        val retrofit:Retrofit

        retrofit =Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)

    }


    fun getNewsByTopic(topic:String,onsuccess:()->String,onfailure:()->Unit){
        service.getByTopic(topic=topic,page=1).enqueue(object:Callback<CallResponse>
        {
            override fun onFailure(call: Call<CallResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>) {
                TODO("Not yet implemented")
            }
        })
    }
    fun getNewsByCountry(Country:String,onsuccess:()->String,onfailure:()->Unit){
        service.getByCountry(country= Country,page=1).enqueue(object:Callback<CallResponse>
        {
            override fun onFailure(call: Call<CallResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>) {
                TODO("Not yet implemented")
            }
        })
    }


}
