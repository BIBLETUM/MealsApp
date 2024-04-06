package com.example.meals.domain

data class Meal (
    val idMeal: String,
    val strMeal: String?,
    val price: Int = 300,
    val ingredients: String?,
    val strCategory: String?,
    val strMealThumb: String?,
    val strArea: String?,
)