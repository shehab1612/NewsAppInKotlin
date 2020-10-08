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
    fun APIgetCountryNews(country:String="eg"):MutableLiveData<MutableList<NewsModel>>
    {

       newsFromAPI.postValue(APIClient.getNewsByCountry(country ))
        return newsFromAPI
    }
}