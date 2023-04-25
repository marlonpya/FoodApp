package com.example.foodapp.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    private val baseActivity by lazy { activity as BaseActivity }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ui()
    }

    abstract fun ui()

    open fun showLoading() {
        baseActivity.showLoading()
    }

    open fun hideLoading() {
        baseActivity.hideLoading()
    }

}