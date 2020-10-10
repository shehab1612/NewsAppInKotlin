package com.example.newsappinkotlin.APIServices

import android.widget.ImageView
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "news_table")
data class NewsModel
    (
    //@SerializedName ("source") val source: mySource,
    @SerializedName ("author") val author: String,
    @SerializedName ("title") val title: String,
    @SerializedName ("url") val url: String,
    @SerializedName ("urlToImage") val Image: String,
    @SerializedName ("publishedAt") val Date: String,
    @SerializedName ("content") val content: String,
  //for offline supported image
    var savedImage:ImageView)
     {
         init {
             savedImage=ImageView(null)
         }
}