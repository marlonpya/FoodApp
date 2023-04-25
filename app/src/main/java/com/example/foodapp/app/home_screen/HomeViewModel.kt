package com.example.foodapp.app.home_screen

import androidx.lifecycle.MutableLiveData
import com.example.foodapp.app.BaseViewModel
import com.example.foodapp.app.model.FoodListModel
import com.example.foodapp.app.utils.DispatcherProvider
import com.example.foodapp.domain.CustomResult
import com.example.foodapp.domain.model.FoodListEntity
import com.example.foodapp.domain.usecase.GetFoodsUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: GetFoodsUseCase,
    private val dispatcherProvider: DispatcherProvider
) : BaseViewModel() {
    val foodMutableLiveData = MutableLiveData<List<FoodListModel>>()

    fun callGetFoods() {
        GlobalScope.launch(dispatcherProvider.IO + dispatcherProvider.coroutineExceptionHandler { _, ex ->
            loadMLD.postValue(false)
            messageMLD.postValue(ex.message ?: "")
        }) {
            loadMLD.postValue(true)
            when (val result = useCase.execute()) {
                is CustomResult.OnSuccess -> {
                    loadMLD.postValue(false)
                    foodMutableLiveData.postValue(result.data.map {
                        FoodListModel(
                            it.id,
                            it.name,
                            it.image,
                            it.description,
                            it.latitude,
                            it.longitude
                        )
                    })
                }
                is CustomResult.OnError -> {
                    loadMLD.postValue(false)
                    messageMLD.postValue(result.error.message ?: "")
                }
            }
        }
    }

}