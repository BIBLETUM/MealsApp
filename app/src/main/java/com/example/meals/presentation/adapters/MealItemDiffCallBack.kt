package com.example.meals.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.meals.domain.Meal

object MealItemDiffCallBack : DiffUtil.ItemCallback<Meal>() {

    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }

}