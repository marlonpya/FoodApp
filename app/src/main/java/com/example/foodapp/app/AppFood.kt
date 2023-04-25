package com.example.foodapp.app

import android.app.Application
import com.example.foodapp.app.di.viewModelsModule
import com.example.foodapp.data.RestApi
import com.example.foodapp.data.networkModule
import com.example.foodapp.domain.domainModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppFood: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppFood)
            modules(listOf(networkModule, domainModule, viewModelsModule))
        }
        getKoin().setProperty(RestApi.BASE_URL_NAME, RestApi.BASE_URL)
    }
}