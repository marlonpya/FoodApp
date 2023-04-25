package com.example.foodapp.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected val loadMLD by lazy { LoadMutableLiveData() }
    val loadLD: LiveData<Boolean>
        get() = loadMLD

    protected val messageMLD by lazy { MessageMutableLiveData() }
    val messageLD: LiveData<String>
        get() = messageMLD
}

class LoadMutableLiveData : MutableLiveData<Boolean>()

class MessageMutableLiveData: MutableLiveData<String>()