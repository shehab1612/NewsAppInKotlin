package com.example.newsappinkotlin.ui.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.MainActivity
import com.example.newsappinkotlin.NewsAdapter
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.viewmodels.newsViewModel
import kotlinx.android.synthetic.main.fragment_headlines.*

class HeadlinesFragment : Fragment() {
   lateinit var  news_adapter:NewsAdapter
    lateinit var llm:LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_headlines, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var liveData: MutableList<NewsModel>
        liveData= mutableListOf()
        super.onViewCreated(view, savedInstanceState)

        news_adapter= NewsAdapter(liveData)
news_recycler.adapter=news_adapter
        llm = LinearLayoutManager(
            this.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        news_recycler.layoutManager=llm
        MainActivity.VM.APIgetTopicNews("all").observe(viewLifecycleOwner, Observer {
            liveData=it
        })

    }
}