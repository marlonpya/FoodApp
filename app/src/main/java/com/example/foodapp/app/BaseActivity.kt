package com.example.foodapp.app

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.foodapp.R

open class BaseActivity: AppCompatActivity() {

    private val foodDialog: ProgressDialog by lazy { initProgress() }

    private fun initProgress(): ProgressDialog {
        val loProgress = object : ProgressDialog(this, R.style.FoodDialog) {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.food_dialog)
                window!!.setLayout(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
            }
        }
        loProgress.setCancelable(false)
        return loProgress
    }

    fun showLoading() {
        if (!foodDialog.isShowing) {
            foodDialog.show()
        }
    }

    fun hideLoading() {
        if (foodDialog.isShowing) {
            foodDialog.dismiss()
        }
    }
}