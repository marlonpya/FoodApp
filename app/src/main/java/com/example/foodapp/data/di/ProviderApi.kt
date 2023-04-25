package com.example.foodapp.data.di

import com.example.foodapp.data.network.FoodService
import retrofit2.Retrofit

fun providerFoodService(retrofit: Retrofit): FoodService {
    return retrofit.create(FoodService::class.java)
}