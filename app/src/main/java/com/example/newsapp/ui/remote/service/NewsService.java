package com.example.newsapp.ui.remote.service;
import android.database.Observable;

import retrofit2.http.GET;


   public interface NewsService {
    @GET("top-headlines?sources=google-news")
    Observable<NewsDetails> getTopHeadlines();
}
