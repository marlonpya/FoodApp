package com.example.foodapp.app.home_screen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.app.model.FoodListModel
import com.example.foodapp.databinding.FoodItemBinding

class FoodListViewHolder(private val view: FoodItemBinding) : RecyclerView.ViewHolder(view.root) {

    fun bind(model: FoodListModel, listener: FoodListListener?) = with(view) {
        txtName.text = model.name
        Glide.with(view.root.context)
            .load(model.image)
            .centerInside()
            .into(image)
        root.setOnClickListener { listener?.invoke(model) }
    }
}