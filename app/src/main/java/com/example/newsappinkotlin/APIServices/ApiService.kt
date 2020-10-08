package com.example.newsappinkotlin.APIServices

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path
interface ApiService {


//gets top headlines by country called and will be defaulted to egypt in cas no country chosen from  spinner
  /*  @GET("top-headlines?country={country}")
    fun getByCountry(@Query("apiKey") apiKey:String="4451200787294791a3863b9dcd8c9903",
    @Path("country")country:String="eg",@Query("page")page:Int=1): Call<CallResponse>*/
    //gets news about what the user searches for and will be defaulted to all topics
    @GET("top-headlines?")
    fun getByCountry(@Query("country")country:String="eg",@Query("apiKey") apiKey:String="4451200787294791a3863b9dcd8c9903"/*,@Query("page") page:Int=1*/): Call<CallResponse>

}