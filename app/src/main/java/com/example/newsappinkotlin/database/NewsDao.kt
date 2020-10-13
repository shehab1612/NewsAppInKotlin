package com.example.newsappinkotlin.database

import androidx.room.*
import com.example.newsappinkotlin.APIServices.NewsModel

@Dao
interface NewsDao{
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insertNews(newsModel: NewsModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(newsModel: MutableList<NewsModel>)

    @Query("SELECT * FROM news_table")
    fun getAllNews(): List<NewsModel>
    @Delete
    fun delete(model:NewsModel)
}