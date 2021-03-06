package com.example.newsappinkotlin.APIServices

import com.google.gson.annotations.SerializedName

data class CallResponse
    (
    @SerializedName("articles")var news:MutableList<NewsModel>,
    @SerializedName("totalResults") val resultsnum: Int,
    @SerializedName("status") val status: String

)
{
}
