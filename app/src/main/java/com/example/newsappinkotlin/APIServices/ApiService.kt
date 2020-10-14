package com.example.newsappinkotlin.APIServices

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path
interface ApiService {


    //gets top headlines by country called and will be defaulted to egypt in cas no country chosen from  spinner
    @GET("v2/top-headlines")
      fun getByCountry(@Query("apiKey") apiKey:String="7bcae687ee8f46e8966ae70051257cce",
                       @Query("country")country:String="eg"): Call<CallResponse>
    //gets news about what the user searches for and will be defaulted to all topics
    @GET("v2/everything")
    fun getByTopic(
        @Query("q")topic:String="all",
        @Query("apiKey") apiKey:String="7bcae687ee8f46e8966ae70051257cce"
         ,@Query("page")page:Int=1): Call<CallResponse>

}