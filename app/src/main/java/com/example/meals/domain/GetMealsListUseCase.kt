package com.example.meals.domain

import javax.inject.Inject

class GetMealsListUseCase @Inject constructor(private val repository: MealsRepository) {

    operator fun invoke() = repository.getMealsList()

}