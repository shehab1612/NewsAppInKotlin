package com.example.newsappinkotlin.APIServices

import com.google.gson.annotations.SerializedName

data class CallResponse
    (
    @SerializedName("articles")val news:MutableList<NewsModel>,
    @SerializedName("page") val page: Int

)
