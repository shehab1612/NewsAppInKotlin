package com.example.newsappinkotlin.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappinkotlin.APIServices.NewsModel

class newsViewModel:ViewModel()
{
lateinit var newsfromdatabase:MutableLiveData<NewsModel>
    lateinit var newsFromAPI:MutableLiveData<NewsModel>
}