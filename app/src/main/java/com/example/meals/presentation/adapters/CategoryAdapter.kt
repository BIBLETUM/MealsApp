package com.example.meals.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.meals.databinding.CategoryItemDisabledBinding
import com.example.meals.databinding.CategoryItemEnabledBinding
import com.example.meals.domain.Category

class CategoryAdapter(
) : ListAdapter<Category, ViewHolder>(CategoryDiffCallBack) {

    var onCategoryClickListener: OnCategoryClickListener? = null

    private var selectedPosition = INITIAL_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            VIEW_TYPE_DISABLED -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = CategoryItemDisabledBinding.inflate(inflater, parent, false)
                CategoryDisabledViewHolder(binding)
            }

            VIEW_TYPE_ENABLED -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = CategoryItemEnabledBinding.inflate(inflater, parent, false)
                CategoryEnabledViewHolder(binding)
            }

            else -> throw Exception("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = getItem(position)
        if (holder is CategoryEnabledViewHolder) {
            val binding = holder.binding
            binding.category.text = category.strCategory
            binding.root.setOnClickListener {
                setUpCategoryListener(holder, category)
            }
        } else if (holder is CategoryDisabledViewHolder) {
            val binding = holder.binding
            binding.category.text = category.strCategory
            binding.root.setOnClickListener {
                setUpCategoryListener(holder, category)
            }
        }
    }

    private fun setUpCategoryListener(holder: ViewHolder, category: Category) {
        selectedPosition = holder.adapterPosition
        notifyItemChanged(holder.adapterPosition)
        onCategoryClickListener?.onCategoryClick(category)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == selectedPosition) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    interface OnCategoryClickListener {
        fun onCategoryClick(category: Category)
    }

    inner class CategoryEnabledViewHolder(val binding: CategoryItemEnabledBinding) :
        ViewHolder(binding.root)

    inner class CategoryDisabledViewHolder(val binding: CategoryItemDisabledBinding) :
        ViewHolder(binding.root)

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0
        const val INITIAL_POSITION = -1
    }
}