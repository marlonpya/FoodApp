package com.example.foodapp.data.network

import com.example.foodapp.data.utils.toObject
import okhttp3.ResponseBody
import retrofit2.Response


abstract class ApiError {

    abstract fun <T> isSuccess(poResponse: Response<T?>?): Boolean

    inline fun <reified E> toError(poError: ResponseBody?): E? {
        return poError?.string()?.toObject()
    }
}