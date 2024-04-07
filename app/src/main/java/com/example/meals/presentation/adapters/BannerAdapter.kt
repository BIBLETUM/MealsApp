package com.example.meals.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.meals.databinding.ItemBannerBinding
import com.example.meals.domain.Banner

class BannerAdapter(
    private val context: Context
) : ListAdapter<Banner, BannerViewHolder>(BannerDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = ItemBannerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = getItem(position)
        val binding = holder.binding

        with(binding) {
            bannerImageView.setImageResource(banner.resId)
        }
    }

}