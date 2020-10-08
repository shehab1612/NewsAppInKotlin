package com.example.newsappinkotlin.APIServices

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    var service:ApiService
    val baseurl="https://newsapi.org/v2/"
val apiKey:String="4451200787294791a3863b9dcd8c9903"
    init { val callResponse:MutableLiveData<List<CallResponse>>

        val retrofit:Retrofit

        retrofit =Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)

    }


    fun getNewsByTopic(topic:String,onsuccess:(newslist:MutableList<NewsModel>)->MutableLiveData<MutableList<NewsModel>>,onfailure:()->Unit){
        service.getByTopic().enqueue(object:Callback<CallResponse>
        {
            override fun onFailure(call: Call<CallResponse>, t: Throwable)
            {
                Log.d("mo","failure")
            onfailure.invoke()
            }

            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>)
            {   Log.d("response","returned")
                if(response.isSuccessful){
            if (response.body()!==null)
                {   Log.d("mo","success")
                   Log.d("nnn","not null")
                    onsuccess.invoke(response.body()!!.news)
                }
                    else {
                onfailure.invoke()
                Log.d("nnn"," null")
            }
                }
                else{

                    Log.d("momomomo","failure")
                }

            }
        })
    }
   /* fun getNewsByCountry(
        Country:String,
        onsuccess: MutableLiveData<MutableList<NewsModel>>,
        onfailure:()->Unit){
        service.getByCountry(country= Country,page=1).enqueue(object:Callback<CallResponse>
        {
            override fun onFailure(call: Call<CallResponse>, t: Throwable)
            {
                onfailure.invoke()
            }

            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>)
            {
                //onsuccess.invoke(response.body()!!.news)
            }
        })
    }*/


}
