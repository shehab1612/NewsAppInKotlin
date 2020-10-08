package com.example.newsappinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsappinkotlin.APIServices.APIClient
import com.example.newsappinkotlin.APIServices.NewsModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val data:MutableList<NewsModel>
        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))

        APIClient.getNewsByTopic("all")
    }
    fun printname(name:String){{Log.d("hello",name)}.invoke()}
    fun getnews(data:MutableList<NewsModel>):MutableLiveData<MutableList<NewsModel>>{
return MutableLiveData(data)
    }
    fun fail(){
        printname("no")
    }

}