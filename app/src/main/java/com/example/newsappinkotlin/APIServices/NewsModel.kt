package com.example.newsappinkotlin.APIServices

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "news_table")
data class NewsModel(
    //@SerializedName ("source") val source: mySource,
    @SerializedName ("author") val author: String,
    @SerializedName ("title") val title: String,
    @PrimaryKey @SerializedName ("url") val url: String,
    @SerializedName ("urlToImage") val Image: String,
    @SerializedName ("publishedAt") val Date: String,
    @SerializedName ("content") val content: String,
  //for offline supported image
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var savedImage: ByteArray? = null) : Serializable
