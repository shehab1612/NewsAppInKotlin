package com.example.newsappinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsappinkotlin.APIServices.APIClient
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.ui.destinations.HeadlinesFragment
import com.example.newsappinkotlin.viewmodels.newsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_headlines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))

    }


}