package com.example.newsappinkotlin.ui.destinations

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.R
import kotlinx.android.synthetic.main.fragment_item_details.*
import kotlinx.android.synthetic.main.fragment_saved_items.*
import java.text.SimpleDateFormat
import java.util.*

class ItemDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_item_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //populate the fragment
        val newsModel = arguments?.getSerializable("news") as NewsModel
        //assuming we are online
        Glide.with(this).load(newsModel.Image).transform(CenterCrop()).into(headImage)
        titleTextView.text = newsModel.title
        contentTextView.text = newsModel.content
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = dateTimeFormat.parse(newsModel.Date)
        dateTimeTextView.text = date.toString()


        //Read full click listener
        readFullButton.setOnClickListener {
            val url = newsModel.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}