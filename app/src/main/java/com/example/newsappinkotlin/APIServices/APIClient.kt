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


    fun getNewsByCountry(topic:String/*,onsuccess:(newslist:MutableList<NewsModel>)->MutableLiveData<MutableList<NewsModel>>,onfailure:()->Unit*/):MutableList<NewsModel>?{
        var newsFetched:MutableList<NewsModel>?= mutableListOf()
        service.getByCountry(apiKey="4451200787294791a3863b9dcd8c9903",country = "eg").enqueue(object:Callback<CallResponse>
        {
            override fun onFailure(call: Call<CallResponse>, t: Throwable)
            {

                Log.d("mo","failure")
            //onfailure.invoke()
            }

            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>)
            {  if(response.isSuccessful)
            {
                if (response.body()!=null)
                {
                    newsFetched?.addAll(response.body()!!.news)
                    Log.d("momomomo", "onResponse: ")
                }
                else
                {
                    Log.d("nppp", "onResponse: nononoon")
                }
            }
                else
            {
                Log.d("not successful", "onResponse: daddfafadf")
            }

            }
        })
        return newsFetched
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
