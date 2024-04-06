package com.example.meals.di

import android.app.Application
import com.example.meals.data.MealsRepositoryImpl
import com.example.meals.data.database.AppDataBase
import com.example.meals.data.database.MealsDao
import com.example.meals.data.network.ApiFactory
import com.example.meals.data.network.ApiService
import com.example.meals.domain.MealsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface ModuleData {

    @Binds
    @ApplicationScope
    fun bindMealRepository(impl: MealsRepositoryImpl): MealsRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideLocalDataSource(application: Application): MealsDao {
            return AppDataBase.getInstance(application).mealsDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }


}