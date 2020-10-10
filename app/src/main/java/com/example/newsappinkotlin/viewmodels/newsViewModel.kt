package com.example.newsappinkotlin.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappinkotlin.APIServices.APIClient
import com.example.newsappinkotlin.APIServices.CallResponse
import com.example.newsappinkotlin.APIServices.NewsModel

class newsViewModel:ViewModel()
{

lateinit var newsfromdatabase:MutableLiveData<MutableList<NewsModel>>


    companion object
    {   var newsFromAPI:MutableLiveData<CallResponse>?=null
        var pagesloaded:Int=1
    }
   /* init {
        newsFromAPI= MutableLiveData()
    }*/

    fun APIgetTopicNews(topic:String="all"):LiveData<CallResponse>?
    {
        Log.d("viewmodel call: ", "APIgetTopicNews: ")

        pagesloaded++
        return APIClient.getNewsByTopic(topic,page=pagesloaded )
      // newsFromAPI.postValue(APIClient.getNewsByCountry(country ))

    }
    /*fun APIgetCountryNews(country:String="eg")
    {
        newsFromAPI?.postValue(APIClient.getNewsByCountry(country))


    }*/


}