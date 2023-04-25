package com.example.foodapp.data.network

import com.example.foodapp.data.RestApi
import retrofit2.Response

open class ApiErrorImpl: ApiError() {

    fun <T> isSuccess(poResponse: Response<T?>?, vararg codesSuccess: Int): Boolean {
        return poResponse != null &&
                poResponse.isSuccessful &&
                codesSuccess.any { poResponse.code() == it }
    }

    override fun <T> isSuccess(poResponse: Response<T?>?): Boolean {
        return isSuccess(poResponse, RestApi.RESPONSE_CODE.OK)
    }
}