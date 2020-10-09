package com.example.newsappinkotlin.ui.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappinkotlin.MainActivity
import com.example.newsappinkotlin.NewsAdapter
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.viewmodels.newsViewModel

class HeadlinesFragment : Fragment() {
   lateinit var  rv:NewsAdapter
    lateinit var llm:LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_headlines, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MainActivity.VM.APIgetTopicNews()
   //     rv= NewsAdapter()
        llm = LinearLayoutManager(
            this.context,
            LinearLayoutManager.VERTICAL,
            false
        )

    }
}