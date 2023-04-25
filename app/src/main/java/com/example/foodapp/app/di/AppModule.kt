package com.example.foodapp.app.di

import com.example.foodapp.app.home_screen.HomeViewModel
import com.example.foodapp.app.utils.DispatcherProvider
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single { DispatcherProvider() }
    viewModel { HomeViewModel(get(), get()) }
}