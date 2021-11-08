package com.example.androidsecondsprint.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidsecondsprint.database.NewsItem
import com.example.androidsecondsprint.repository.Repository
import com.example.androidsecondsprint.response.Article
import com.example.androidsecondsprint.response.ResponseDTO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsViewModel:ViewModel() {


    private val repository=Repository()
    private var articleList= arrayListOf<Article>()
    private val mutableLiveData=MutableLiveData<MainUIModel>()
    val liveData:LiveData<MainUIModel> = mutableLiveData
    private lateinit var disposable: Disposable

    fun apiCall(){
        repository.getAllNews()
            .flatMap { (articles) ->
                Observable.fromIterable(articles)
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Article?> {
                override fun onSubscribe(d: @NonNull Disposable?) {
                    d?.let {
                        disposable=it
                    }
                }
                override fun onNext(article: @NonNull Article?) {
                    article?.let {
                        articleList.add(it)
                    }

                }
                override fun onError(e: @NonNull Throwable?) {
                    e?.message?.let { Log.i("ViewModel", it) }
                }
                override fun onComplete() {
                 mutableLiveData.value=MainUIModel.OnSuccess(articleList)
                }
            })
    }

    fun addNews(newsItem: NewsItem){
        repository.addNewsToRoom(newsItem)
    }



}