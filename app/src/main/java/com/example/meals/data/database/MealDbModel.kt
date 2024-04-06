package com.example.meals.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals_list")
data class MealDbModel(
    @PrimaryKey
    val idMeal: String,
    val strMeal: String?,
    val price: Int = 300,
    val ingredients: String,
    val strCategory: String?,
    val strMealThumb: String?,
    val strArea: String?,
)