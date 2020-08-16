package com.example.newsapp.ui

import android.app.Application
import com.example.newsapp.ui.di.modulesList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        injectKoin()
    }

    private fun injectKoin() {
        startKoin {
            androidContext(this@NewsApp)
            androidLogger()
            modules(modulesList)
        }
    }
}