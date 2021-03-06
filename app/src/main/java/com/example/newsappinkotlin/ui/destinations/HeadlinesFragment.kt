package com.example.newsappinkotlin.ui.destinations

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappinkotlin.NewsAdapter
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.viewmodels.newsViewModel
import kotlinx.android.synthetic.main.fragment_headlines.*

class HeadlinesFragment : Fragment() ,NewsAdapter.onNewsClicked{
    /* *//*  lateinit var  news_adapter:NewsAdapter
    lateinit var llm:LinearLayoutManager*//*
 companion object{

 }*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_headlines, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        var VM: newsViewModel = ViewModelProviders.of(this).get(newsViewModel::class.java)
        VM.APIgetTopicNews("all")

        var llm: LinearLayoutManager


        llm = LinearLayoutManager(
            this.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        news_recycler.layoutManager = llm

        VM.APIgetTopicNews("all")?.observe(viewLifecycleOwner, Observer {
            Log.d("observer reached", "onCreate: ")
            news_recycler.adapter  = NewsAdapter(it.news)
            (news_recycler.adapter as NewsAdapter).addmoreNews(it.news)

        })


    }

    override fun onNewsClicked(position: Int) {
        val intent:Intent
        news_recycler.get(position)
        intent=Intent(this.context,ItemDetailsFragment::class.java)

    }
}