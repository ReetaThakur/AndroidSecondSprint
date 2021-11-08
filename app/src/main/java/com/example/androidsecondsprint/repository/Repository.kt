package com.example.androidsecondsprint.repository

import androidx.lifecycle.LiveData
import com.example.androidsecondsprint.apiCall.Network
import com.example.androidsecondsprint.database.NewsDAO
import com.example.androidsecondsprint.database.NewsItem
import com.example.androidsecondsprint.response.Article
import com.example.androidsecondsprint.response.ResponseDTO
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository() {
    val API_KEY="fbc147d482974d48a2bd20cb8fbfee3a"

    fun getAllNews():Observable<ResponseDTO> {
        return Network.getApiService().getInstance("us",API_KEY)
    }

    fun getRemoteNews(){
        CoroutineScope(Dispatchers.IO).launch {
            val response= getAllNews() as Observable<Article>
            saveToDB(response)
        }
    }

    private fun saveToDB(article: Observable<Article>) {
        val listNews=ArrayList<NewsItem>()
        article.forEach {
            val news=NewsItem(it.title,it.publishedAt,it.description)
            listNews.add(news)
        }

    }

    fun addNewsToRoom(newsItem: NewsItem){
        CoroutineScope(Dispatchers.IO).launch {

        }
    }


}