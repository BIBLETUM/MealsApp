package com.example.meals.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.meals.data.database.MealsDao
import com.example.meals.data.network.ApiService
import com.example.meals.domain.Category
import com.example.meals.domain.Meal
import com.example.meals.domain.MealsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealsDao: MealsDao,
    private val apiService: ApiService,
    private val mapper: MealsMapper
) : MealsRepository {

    override fun getMealsList(): LiveData<List<Meal>> {
        return mealsDao.getMealsList().map { list ->
            list.map { mapper.mapDbMealToEntity(it) }
        }
    }

    override fun getCategoriesList(): LiveData<List<Category>> {
        return mealsDao.getCategoriesList().map { list ->
            list.map { mapper.mapDbCategoryToEntity(it) }
        }
    }

    override suspend fun loadData() {
        while (true) {
            try {
                val meals = apiService.getMealsList().meals.map { mapper.mapDtoMealToDbModel(it) }
                mealsDao.insertMealsList(meals)

                val categories =
                    apiService.getCategoriesList().categories.map {
                        mapper.mapDtoCategoryToDbModel(
                            it
                        )
                    }
                mealsDao.insertCategoriesList(categories)
            } catch (_: Exception) {
            }
            delay(20000)
        }
    }

}