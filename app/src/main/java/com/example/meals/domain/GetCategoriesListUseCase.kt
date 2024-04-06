package com.example.meals.domain

import javax.inject.Inject

class GetCategoriesListUseCase @Inject constructor(private val repository: MealsRepository) {

    operator fun invoke() = repository.getCategoriesList()

}