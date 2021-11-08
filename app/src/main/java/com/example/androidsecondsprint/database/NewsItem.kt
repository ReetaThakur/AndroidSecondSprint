package com.example.androidsecondsprint.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NewsArticle")
data class NewsItem(@ColumnInfo(name = "newsTitle") var title:String,
@ColumnInfo(name = "newsDate") var date:String,
@ColumnInfo(name = "newsDescription") var description:String){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id:Int?=null
}
