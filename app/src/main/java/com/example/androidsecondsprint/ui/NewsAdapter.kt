package com.example.androidsecondsprint.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidsecondsprint.R
import com.example.androidsecondsprint.repository.ClickListner
import com.example.androidsecondsprint.response.Article

class NewsAdapter(private val articleList: List<Article>,val listner: ClickListner):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       val view:View=LayoutInflater.from(parent.context).inflate(R.layout.news_layout,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articleDto=articleList[position]
        holder.setData(articleDto)
        holder.showFullArticle.setOnClickListener {
            listner.showFullArticle(articleDto.url)
        }
        holder.saveArticle.setOnClickListener {
            listner.saveArticle(position)
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }


    class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var newsImage=itemView.findViewById<ImageView>(R.id.newsImage)
        var title=itemView.findViewById<TextView>(R.id.tvTitle)
        var date=itemView.findViewById<TextView>(R.id.tvDate)
        var description=itemView.findViewById<TextView>(R.id.tvDescription)
        var showFullArticle=itemView.findViewById<Button>(R.id.btnShowArticle)
        var saveArticle=itemView.findViewById<Button>(R.id.btnSaveArticle)

        fun setData(article: Article){
            try {
                Glide.with(newsImage).load(article.urlToImage).into(newsImage)
                title.text="Title - ${article.title}"
                date.text="Date - ${article.publishedAt}"
                description.text="Description - ${article.description}"

            }catch (e:Exception){
                e.message
            }
        }
    }
}