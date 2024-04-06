package com.example.meals.domain

import androidx.lifecycle.LiveData

interface MealsRepository {

    fun getMealsList():LiveData<List<Meal>>

    fun getCategoriesList():LiveData<List<Category>>

    suspend fun loadData()

}