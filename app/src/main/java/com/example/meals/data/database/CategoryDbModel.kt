package com.example.meals.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_list")
data class CategoryDbModel(
    @PrimaryKey
    val idCategory: String,
    val strCategory: String?,
    val strCategoryThumb: String?
)