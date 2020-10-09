package com.example.newsappinkotlin.APIServices

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitObj{

    private var retrofit: Retrofit? =null
    fun getRetrofit():Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttp3.OkHttpClient.Builder().build())
                .build()
        }
        return retrofit

    }
}

object APIClient {
    var retrofit = RetrofitObj.getRetrofit()
    val  apiInterface:ApiService by lazy {
        retrofit!!.create(ApiService::class.java)
    }



    fun getNewsByTopic(topic: String="all",page: Int=1):MutableList<NewsModel>{
        val call:Call<CallResponse> = apiInterface.getByTopic(topic,page = page)
        var newsModel: MutableList<NewsModel>
        newsModel= mutableListOf()
        call.enqueue(object : Callback<CallResponse> {
            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>) {
                Log.d("response", "returned")
                if (response.isSuccessful) {
                    if (response.body() !== null) {

                        newsModel.addAll (response.body()!!.news)
                        Log.d("success", "onResponse: ")

                    } else {
                        Log.d("success", "null ")

                    }
                } else {
                    Log.d("success", "failed: ")

                }
            }

            override fun onFailure(call: Call<CallResponse>, t: Throwable) {
                t.printStackTrace()
                // println("call is failed${t.cause}")
                Log.d("failed", "onResponse: ")


            }


        })
        return newsModel}

    fun getNewsByCountry(country: String="eg"):MutableList<NewsModel>{
        val call:Call<CallResponse> = apiInterface.getByCountry(country)
        var newsModel: MutableList<NewsModel>
        newsModel= mutableListOf()
        call.enqueue(object : Callback<CallResponse> {
            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>) {
                Log.d("response", "returned")
                if (response.isSuccessful) {
                    if (response.body() !== null) {

                        newsModel.addAll (response.body()!!.news)
                        Log.d("success", "onResponse: ")

                    } else {
                        Log.d("success", "null ")

                    }
                } else {
                    Log.d("success", "failed: ")

                }
            }

            override fun onFailure(call: Call<CallResponse>, t: Throwable) {
                t.printStackTrace()
                // println("call is failed${t.cause}")
                Log.d("failed", "onResponse: ")


            }


        })
        return newsModel
    }
}

