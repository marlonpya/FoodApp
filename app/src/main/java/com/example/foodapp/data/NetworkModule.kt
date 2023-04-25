package com.example.foodapp.data

import com.example.foodapp.data.di.providerFoodService
import com.example.foodapp.data.network.ApiErrorImpl
import com.example.foodapp.data.repository.FoodsRepositoryImpl
import com.example.foodapp.domain.repository.FoodsRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { providerRetrofit(getProperty(RestApi.BASE_URL_NAME), get()) }
    single { providerOkHttpClient(get()) }
    single { ApiInterceptor() }
    single { providerFoodService(get()) }
    single { ApiErrorImpl() }

    single<FoodsRepository> { FoodsRepositoryImpl(get(), get()) }
}

fun providerRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(baseUrl)
        .build()
}

fun providerOkHttpClient(
    apiInterceptor: ApiInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(RestApi.TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(RestApi.TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(RestApi.TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(apiInterceptor)
        .build()
}

class ApiInterceptor() :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().build()
        return chain.proceed(request)
    }
}