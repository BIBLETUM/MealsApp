package com.example.meals.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.meals.R
import com.example.meals.databinding.ItemMealBinding
import com.example.meals.domain.Meal
import com.squareup.picasso.Picasso

class MealAdapter(
    private val context: Context
) : ListAdapter<Meal, MealViewHolder>(MealItemDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = ItemMealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = getItem(position)
        val binding = holder.binding

        with(binding) {
            val priceTemplate = context.resources.getString(R.string.price_template)
            mealNameTextView.text = meal.strMeal
            mealIngredientsTextView.text = meal.ingredients
            mealPriceButton.text = priceTemplate.format(meal.price)

            Picasso.get().load(meal.strMealThumb).into(mealImageView)
        }
    }
}