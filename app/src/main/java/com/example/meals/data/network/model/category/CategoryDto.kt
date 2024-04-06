package com.example.meals.data.network.model.category

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class CategoryDto(
    @SerializedName("idCategory")
    @Expose
    val idCategory: String,

    @SerializedName("strCategory")
    @Expose
    val strCategory: String?,

    @SerializedName("strCategoryThumb")
    @Expose
    val strCategoryThumb: String?,

    @SerializedName("strCategoryDescription")
    @Expose
    val strCategoryDescription: String?
)