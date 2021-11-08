package com.example.androidsecondsprint.ui

import com.example.androidsecondsprint.response.Article

sealed class MainUIModel{
    data class OnSuccess(val article: List<Article>):MainUIModel()

    data class onFailure(val error:String):MainUIModel()
}
