package com.example.newsappinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.FontResourcesParserCompat
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappinkotlin.APIServices.APIClient
import com.example.newsappinkotlin.APIServices.NewsModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_headlines.*

class MainActivity : AppCompatActivity() {


    private lateinit var newsLayoutManager: LinearLayoutManager

    private var newsPage = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        news_recycler.layoutManager = newsLayoutManager
        var News_Adapter = NewsAdapter(mutableListOf())
        news_recycler.adapter = News_Adapter

        getNews()


        val data:MutableList<NewsModel>
        bottom_nav_view.setupWithNavController(findNavController(R.id.nav_host_fragment_container))

        APIClient.getNewsByCountry("eg")
    }

private fun getNews(){
    Repository.getNews(
        newsPage,
        ::onNewsFetched
    )
}

    private fun attachNewsOnScrollListener(){
        news_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = newsLayoutManager.itemCount
                val visibleItemCount = newsLayoutManager.childCount
                val firstVisibleItem = newsLayoutManager.findFirstVisibleItemPosition()

                    if (firstVisibleItem + visibleItemCount >= totalItemCount / 2){
                        recyclerView.removeOnScrollListener(this)
                        newsPage++
                        getNews()
                    }
            }
        })
    }

    private fun onNewsFetched(news: MutableList<NewsModel>){
    NewsAdapter(mutableListOf()).addmoreNews(news)
    attachNewsOnScrollListener()
}

}
