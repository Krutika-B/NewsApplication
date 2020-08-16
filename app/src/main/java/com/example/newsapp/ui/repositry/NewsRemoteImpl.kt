package com.example.newsapp.ui.repositry

import android.database.Observable
import com.example.newsapp.ui.remote.service.NewsDetails
import com.example.newsapp.ui.remote.service.NewsRemote
import com.example.newsapp.ui.remote.service.NewsService
class NewsRemoteImpl(
        private val newsService: NewsService
) : NewsRemote {

    override fun getTopHeadlines(): Observable<NewsDetails> {
        return newsService.getTopHeadlines()
    }
}
