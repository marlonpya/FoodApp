package com.example.foodapp.domain.repository

import com.example.foodapp.domain.CustomResult
import com.example.foodapp.domain.model.FoodEntity
import com.example.foodapp.domain.model.FoodListEntity

interface FoodsRepository {

    fun getFoods(): CustomResult<List<FoodListEntity>>
}