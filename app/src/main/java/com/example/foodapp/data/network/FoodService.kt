package com.example.foodapp.data.network

import com.example.foodapp.data.RestApi
import com.example.foodapp.data.model.FoodListResponse
import retrofit2.Call
import retrofit2.http.*

interface FoodService {

    @GET(RestApi.FOODS.LIST_FOODS)
    fun callFoods(): Call<List<FoodListResponse>?>?
}