package com.example.foodapp.data.utils

import com.google.gson.Gson

inline fun <reified T> String.toObject(): T? {
    return Gson().fromJson<T>(this, T::class.java)
}