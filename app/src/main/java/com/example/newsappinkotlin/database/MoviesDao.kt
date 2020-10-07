package com.example.newsappinkotlin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsappinkotlin.APIServices.NewsModel

@Dao
interface MoviesDao{
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insertNews(newsModel: NewsModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(newsModel: NewsModel)

    @Query("SELECT * FROM news_table")
    fun getAllMovies(): List<NewsModel>

}