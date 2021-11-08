package com.example.androidsecondsprint.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(newsItem: NewsItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllNews(newsItem: ArrayList<NewsItem>)

    @Query("select * from NewsArticle")
    fun getNews():LiveData<List<NewsItem>>
}