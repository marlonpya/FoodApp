package com.example.foodapp.domain.usecase

import com.example.foodapp.domain.repository.FoodsRepository

class GetFoodsUseCase(private val repository: FoodsRepository) {

    fun execute() = repository.getFoods()
}