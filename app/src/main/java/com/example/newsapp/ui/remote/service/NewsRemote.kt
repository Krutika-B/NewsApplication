package com.example.newsapp.ui.remote.service

import android.database.Observable

interface NewsRemote {

    fun getTopHeadlines() : Observable<NewsDetails>
}