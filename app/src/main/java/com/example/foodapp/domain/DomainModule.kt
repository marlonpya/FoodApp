package com.example.foodapp.domain

import com.example.foodapp.domain.usecase.GetFoodsUseCase
import org.koin.dsl.module

val domainModule = module {

    single { GetFoodsUseCase(get()) }
}