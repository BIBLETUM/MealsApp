package com.example.meals.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.domain.GetCategoriesListUseCase
import com.example.meals.domain.GetMealsListUseCase
import com.example.meals.domain.LoadDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCategoriesListUseCase: GetCategoriesListUseCase,
    private val getMealsListUseCase: GetMealsListUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val categoriesList = getCategoriesListUseCase.invoke()
    val mealsList = getMealsListUseCase.invoke()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                loadDataUseCase.invoke()
            }
        }
    }
}