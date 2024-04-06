package com.example.meals.domain

import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: MealsRepository) {

    suspend operator fun invoke() = repository.loadData()

}