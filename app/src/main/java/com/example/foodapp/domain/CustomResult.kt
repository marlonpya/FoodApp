package com.example.foodapp.domain

sealed class CustomResult<out T> {
    data class OnSuccess<out T>(val data: T) : CustomResult<T>()
    data class OnError<out T>(val error: CustomError) : CustomResult<T>()
}


open class CustomError (
    val code: String? = "",
    val message: String? = null,
    val cause: Throwable? = null
)

class UnknownError(code: String? = "", message: String? = null, cause: Throwable? = null):
    CustomError(code, message ?: "Unknown error", cause)