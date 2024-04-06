package com.example.meals.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealsDao {
    @Query("SELECT * FROM categories_list ORDER BY strCategory DESC")
    fun getCategoriesList(): LiveData<List<CategoryDbModel>>

    @Query("SELECT * FROM meals_list ORDER BY strCategory DESC")
    fun getMealsList(): LiveData<List<MealDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoriesList(categoriesList: List<CategoryDbModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealsList(mealsList: List<MealDbModel>)
}