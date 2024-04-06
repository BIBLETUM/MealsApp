package com.example.meals.data

import com.example.meals.data.database.CategoryDbModel
import com.example.meals.data.database.MealDbModel
import com.example.meals.data.network.model.category.CategoryDto
import com.example.meals.data.network.model.meal.MealDto
import com.example.meals.domain.Category
import com.example.meals.domain.Meal
import javax.inject.Inject

class MealsMapper @Inject constructor() {

    fun mapDbMealToEntity(mealDb: MealDbModel) = Meal(
        idMeal = mealDb.idMeal,
        strMeal = mealDb.strMeal,
        strCategory = mealDb.strCategory,
        ingredients = mealDb.ingredients,
        strMealThumb = mealDb.strMealThumb,
        strArea = mealDb.strArea
    )

    fun mapDbCategoryToEntity(categoryDb: CategoryDbModel) = Category(
        idCategory = categoryDb.idCategory,
        strCategory = categoryDb.strCategory,
        strCategoryThumb = categoryDb.strCategoryThumb
    )

    fun mapDtoMealToDbModel(mealDto: MealDto) = MealDbModel(
        idMeal = mealDto.idMeal,
        strMeal = mealDto.strMeal,
        strCategory = mealDto.strCategory,
        ingredients = mapIngredients(mealDto),
        strMealThumb = mealDto.strMealThumb,
        strArea = mealDto.strArea
    )

    fun mapDtoCategoryToDbModel(categoryDto: CategoryDto) = CategoryDbModel(
        idCategory = categoryDto.idCategory,
        strCategory = categoryDto.strCategory,
        strCategoryThumb = categoryDto.strCategoryThumb
    )

    private fun mapIngredients(mealDto: MealDto): String {
        val list = listOf(
            mealDto.strIngredient1,
            mealDto.strIngredient2,
            mealDto.strIngredient3,
            mealDto.strIngredient4,
            mealDto.strIngredient5,
            mealDto.strIngredient6,
            mealDto.strIngredient7,
            mealDto.strIngredient8,
            mealDto.strIngredient9,
            mealDto.strIngredient10,
            mealDto.strIngredient11,
            mealDto.strIngredient12,
            mealDto.strIngredient13,
            mealDto.strIngredient14,
            mealDto.strIngredient15,
            mealDto.strIngredient16,
            mealDto.strIngredient17,
            mealDto.strIngredient18,
            mealDto.strIngredient19,
            mealDto.strIngredient20
        )
        return list.filter { it != "" }
            .filterNotNull()
            .toString()
            .replace("[", "")
            .replace("]", "")
    }

}