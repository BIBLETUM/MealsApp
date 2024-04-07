package com.example.meals.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.meals.domain.Banner

object BannerDiffCallBack : DiffUtil.ItemCallback<Banner>() {

    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}