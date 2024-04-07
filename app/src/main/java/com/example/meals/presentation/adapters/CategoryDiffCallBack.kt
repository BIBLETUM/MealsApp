package com.example.meals.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.meals.domain.Category

object CategoryDiffCallBack : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.idCategory == newItem.idCategory
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}