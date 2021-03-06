package com.example.newsappinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsappinkotlin.APIServices.APIClient
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.database.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data:MutableList<NewsModel>
        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))

        APIClient.getNewsByCountry("eg")
        AppDatabase.getDatabase(this)
    }

}