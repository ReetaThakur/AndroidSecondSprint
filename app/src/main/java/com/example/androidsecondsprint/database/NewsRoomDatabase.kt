package com.example.androidsecondsprint.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//@Database(entities = [NewsItem::class],version=1)
//abstract class NewsRoomDatabase:RoomDatabase() {
//    abstract fun getNewsDao():NewsRoomDatabase
//
//    companion object{
//        private var INSTANCE :NewsRoomDatabase?=null
//        fun getDatabaseObject(context: Context):NewsRoomDatabase{
//            if (INSTANCE==null){
//                val builder=Room.databaseBuilder(context.applicationContext,NewsRoomDatabase::class.java,"news_database")
//                builder.fallbackToDestructiveMigration()
//                INSTANCE=builder.build()
//                return INSTANCE!!
//            }else{
//                return INSTANCE!!
//            }
//        }
//    }
//
//}