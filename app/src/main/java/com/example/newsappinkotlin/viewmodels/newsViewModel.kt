package com.example.newsappinkotlin.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappinkotlin.APIServices.APIClient
import com.example.newsappinkotlin.APIServices.NewsModel

class newsViewModel:ViewModel()
{

lateinit var newsfromdatabase:MutableLiveData<MutableList<NewsModel>>
    companion object
    {
        var pagesloaded:Int=1
    }
lateinit   var newsFromAPI:MutableLiveData<MutableList<NewsModel>>
    fun APIgetTopicNews(topic:String="all",page:Int=1):MutableLiveData<MutableList<NewsModel>>
    {newsFromAPI=MutableLiveData<MutableList<NewsModel>>()
newsFromAPI.postValue(APIClient.getNewsByTopic(topic,page=pagesloaded ))
      // newsFromAPI.postValue(APIClient.getNewsByCountry(country ))
        return newsFromAPI
    }
}