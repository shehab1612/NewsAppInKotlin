package com.example.newsappinkotlin.APIServices

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/everything")
    fun getCountry(@Query("api_Key")apiKey:String="4451200787294791a3863b9dcd8c9903",
                   @path("country")country:String="eg",
                   @Query("page") pageNumber: Int = 1): Call<NewsModel>
    @GET("v2/top-headlines")
    fun getTopic(@Query("api_Key")apiKey:String="4451200787294791a3863b9dcd8c9903",
                 @path("q")topic:String="all",
                 @Query("page") pageNumber: Int = 1):Call<NewsModel>
}