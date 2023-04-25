package com.example.foodapp.app.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import com.example.foodapp.domain.UnknownError

open class DispatcherProvider {

    open val IO: CoroutineDispatcher = Dispatchers.IO
    open val Main: CoroutineDispatcher = Dispatchers.Main
    open val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined

    public inline fun coroutineExceptionHandler(
        crossinline handler: (CoroutineContext, UnknownError) -> Unit): CoroutineExceptionHandler =

        object : AbstractCoroutineContextElement(CoroutineExceptionHandler),
            CoroutineExceptionHandler {
            override fun handleException(context: CoroutineContext, exception: Throwable) =
                handler.invoke(context, UnknownError())
        }
}