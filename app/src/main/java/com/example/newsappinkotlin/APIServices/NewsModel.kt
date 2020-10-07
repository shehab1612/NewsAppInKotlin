package com.example.newsappinkotlin.APIServices

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "news_table")
data class NewsModel
    (
    @SerializedName ("source") val source: mySource,
    @SerializedName ("author") val author: String,
    @SerializedName ("title") val title: String,
    @SerializedName ("url") val url: String,
    @SerializedName ("urlToImage") val Image: String,
    @SerializedName ("publishedAt") val Date: Date,
    @SerializedName ("content") val content: Date




    ) {
}