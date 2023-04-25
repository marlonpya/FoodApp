package com.example.foodapp.domain.model

data class FoodListEntity(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val latitude: String,
    val longitude: String
)