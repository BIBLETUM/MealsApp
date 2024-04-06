package com.example.meals.data.network.model.category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoriesListDto(

    @SerializedName("categories")
    @Expose
    val categories: List<CategoryDto>
)
