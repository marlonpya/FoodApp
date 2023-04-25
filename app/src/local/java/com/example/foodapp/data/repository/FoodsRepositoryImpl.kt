package com.example.foodapp.data.repository

import com.example.foodapp.data.model.FoodListResponse
import com.example.foodapp.data.network.ApiErrorImpl
import com.example.foodapp.data.network.FoodService
import com.example.foodapp.domain.CustomResult
import com.example.foodapp.domain.model.FoodListEntity
import com.example.foodapp.domain.repository.FoodsRepository

class FoodsRepositoryImpl(
    private val api: FoodService,
    private val apiError: ApiErrorImpl
) : FoodsRepository {

    override fun getFoods(): CustomResult<List<FoodListEntity>> {
        return CustomResult.OnSuccess(fake().map {
            FoodListEntity(
                it.id!!,
                it.name!!,
                it.image!!,
                it.description!!,
                it.latitude!!,
                it.longitude!!
            )
        })
    }

    private fun fake() = listOf(
        FoodListResponse(
            "1",
            "Sopa seca",
            "https://comidasperuanas.net/wp-content/uploads/2020/10/Sopa-Seca.jpg",
            "Comida típica de Cañete",
            "-12.7987441",
            "-76.6468817"
        ),
        FoodListResponse(
            "2",
            "Ceviche",
            "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg",
            "Comida típica de Lima",
            "-12.0262674",
            "-77.1282048"
        ),
        FoodListResponse(
            "3",
            "Lomo Saltado",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Lomo-saltado-perudelights.jpg/640px-Lomo-saltado-perudelights.jpg",
            "Comida típica del Norte de Lima",
            "-3.7525353",
            "-73.5535592"
        ),
        FoodListResponse(
            "4",
            "Ají de Gallina",
            "https://t1.rg.ltmcdn.com/es/posts/3/8/7/aji_de_pollo_16783_orig.jpg",
            "Comida típica del Norte de Lima",
            "-16.4059429",
            "-71.5772401"
        ),
        FoodListResponse(
            "5",
            "Causa",
            "https://t2.rg.ltmcdn.com/es/posts/8/6/2/causa_limena_31268_orig.jpg",
            "Comida típica de Lima",
            "-12.0038596",
            "-77.1529952"
        ),
        FoodListResponse(
            "6",
            "Pachamanca",
            "https://comidasperuanas.net/wp-content/uploads/2019/01/Pachamanca-a-la-olla.jpg",
            "Comida típica de la Sierra",
            "-12.0484232",
            "-75.2377443"
        ),
        FoodListResponse(
            "7",
            "Arroz con pollo",
            "https://comidasperuanas.net/wp-content/uploads/2015/07/Arroz-con-pollo-peruano.jpg",
            "Comida típica de Lima",
            "-15.8467711",
            "-70.0514935"
        ),
    )
}