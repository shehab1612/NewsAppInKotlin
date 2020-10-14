package com.example.newsappinkotlin.ui.destinations

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.newsappinkotlin.APIServices.NewsModel
import com.example.newsappinkotlin.R
import com.example.newsappinkotlin.database.AppDatabase
import kotlinx.android.synthetic.main.fragment_headlines.view.*
import kotlinx.android.synthetic.main.fragment_item_details.*
import kotlinx.android.synthetic.main.fragment_saved_items.*
import kotlinx.android.synthetic.main.news_card.view.*
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

class ItemDetailsFragment : Fragment() {
    lateinit var dataBase: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_item_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //populate the fragment
        val newsModel = arguments?.getSerializable("news") as NewsModel
        if(newsModel.savedImage==null)
            Glide.with(this).load(newsModel.Image).transform(CenterCrop()).into(headImage)
        else
            headImage.setImageBitmap(newsModel.savedImage?.size?.let {
                BitmapFactory.decodeByteArray(newsModel.savedImage , 0,
                    it
                )
            })
        titleTextView.text = newsModel.title
        contentTextView.text = newsModel.content
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = dateTimeFormat.parse(newsModel.Date)
        dateTimeTextView.text = date.toString()

        save.setOnClickListener {
            dataBase = AppDatabase.getDatabase(this.requireContext())
            val newsmodel = newsModel
            Glide.with(this.requireContext())
                .asBitmap()
                .load(newsmodel?.Image)
                .into(object : CustomTarget<Bitmap>(500,500) {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        val stream = ByteArrayOutputStream()

                        resource.compress(Bitmap.CompressFormat.PNG, 100, stream)

                        newsmodel?.savedImage = stream.toByteArray()
                        newsmodel?.let { it1 -> dataBase.getNewsDao().insertNews(it1) }

                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
            Toast.makeText(this.requireContext(),"SAVED", Toast.LENGTH_SHORT).show()
        }
        //Read full click listener
        readFullButton.setOnClickListener {
            val url = newsModel.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}