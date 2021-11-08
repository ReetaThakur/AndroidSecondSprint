package com.example.androidsecondsprint.response

data class ResponseDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)