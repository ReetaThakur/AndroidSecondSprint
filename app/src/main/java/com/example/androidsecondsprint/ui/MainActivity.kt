package com.example.androidsecondsprint.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidsecondsprint.R
import com.example.androidsecondsprint.database.NewsItem
import com.example.androidsecondsprint.repository.ClickListner
import com.example.androidsecondsprint.response.Article
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ClickListner {
    private lateinit var viewModel: NewsViewModel
    private lateinit var article: Article
    private var list= emptyList<Article>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.apiCall()
        viewModel.liveData.observe(this,{
            it.let {
                when(it){
                   is MainUIModel.OnSuccess ->{
                       list= it.article
                       setRecyclerView()

                   }
                    is MainUIModel.onFailure ->{
                        Toast.makeText(this,it.error,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setRecyclerView(){
        val adapterList=NewsAdapter(list,this)
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerView.apply {
            adapter=adapterList
            layoutManager=linearLayoutManager
        }
    }

    override fun showFullArticle(uri1:String) {
        var uri=Uri.parse(uri1)
        val intent=Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }

    override fun saveArticle(position: Int) {
        var news=NewsItem(article.title,article.publishedAt,article.description)
        viewModel.addNews(news)
    }
}