package com.example.meals.data.network

import com.example.meals.data.network.model.category.CategoriesListDto
import com.example.meals.data.network.model.meal.MealsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php?s")
    suspend fun getMealsList(): MealsListDto

    @GET("categories.php")
    suspend fun getCategoriesList(): CategoriesListDto

}