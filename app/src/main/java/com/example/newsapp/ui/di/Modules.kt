package com.example.newsapp.ui.di

import com.example.newsapp.ui.remote.service.NewsRemote
import com.example.newsapp.ui.remote.service.NewsService
import com.example.newsapp.ui.remote.util.NewsInterceptor
import com.example.newsapp.ui.repositry.NewsRemoteImpl
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val modulesList by lazy {
    listOf(
            remoteModule
    )
}

val remoteModule: Module = module {
    single<NewsRemote> { NewsRemoteImpl(newsService = get()) }
    single<NewsService> { retrofit.create(NewsService::class.java) }
}

private const val BASE_URL = "https://newsapi.org"
private const val NEWS_API_KEY = "e278e8b7d8404132a36fe1f1a2fde799"


private val retrofit = createRetrofit(BASE_URL)

private fun createRetrofit(baseUrl: String): Retrofit {
    return Retrofit.Builder()
            .client(createOkHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
            .addInterceptor(NewsInterceptor(NEWS_API_KEY))
            .build()
}