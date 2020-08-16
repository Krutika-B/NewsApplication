package com.example.newsapp.ui.remote.util

import okhttp3.Interceptor
import retrofit2.Response
import java.io.IOException

class NewsInterceptor constructor(private val apiKey: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        val url = request.url().newBuilder().addQueryParameter("apiKey", apiKey).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}