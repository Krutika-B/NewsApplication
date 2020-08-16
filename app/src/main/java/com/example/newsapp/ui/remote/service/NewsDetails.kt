package com.example.newsapp.ui.remote.service

data class NewsDetails(
        val articles: List<Article>
) {
    data class Article(
            val author: String?,
            val title: String?,
            val description: String?,
            val url: String?,
            val urlToImage: String?,
            val publishedAt: String?,
            val content: String?
    )
}