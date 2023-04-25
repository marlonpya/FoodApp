package com.example.foodapp.app.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.app.model.FoodListModel
import com.example.foodapp.databinding.FoodItemBinding


typealias FoodListListener = ((FoodListModel) -> Unit)

class FoodListAdapter(var listener: FoodListListener) : RecyclerView.Adapter<FoodListViewHolder>(){
    var list: List<FoodListModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FoodListViewHolder(
            FoodItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount() = list.size

    fun setData(list: List<FoodListModel>) {
        this.list = list
    }

}