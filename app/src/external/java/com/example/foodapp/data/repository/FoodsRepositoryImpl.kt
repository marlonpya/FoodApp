package com.example.foodapp.data.repository

import com.example.foodapp.data.error.FoodException
import com.example.foodapp.data.network.ApiErrorImpl
import com.example.foodapp.data.network.FoodService
import com.example.foodapp.domain.CustomResult
import com.example.foodapp.domain.model.FoodListEntity
import com.example.foodapp.domain.repository.FoodsRepository

class FoodsRepositoryImpl(
    private val api: FoodService,
    private val apiErrorImpl: ApiErrorImpl
): FoodsRepository {
    override fun getFoods(): CustomResult<List<FoodListEntity>> {
        val call = api.callFoods()?.execute()
        return if (apiErrorImpl.isSuccess(call)) {
            CustomResult.OnSuccess(call?.body()?.map { FoodListEntity(
                it.id ?: "",
                it.name ?: "",
                it.image ?: "",
                it.description ?: "",
                it.latitude ?: "",
                it.longitude ?: ""
            ) }
                ?: emptyList())
        } else {
            val error = apiErrorImpl.toError<FoodException?>(call?.errorBody())
            CustomResult.OnError(
                com.example.foodapp.domain.UnknownError(code = error?.code ?: "", message = error?.description)
            )
        }
    }


}