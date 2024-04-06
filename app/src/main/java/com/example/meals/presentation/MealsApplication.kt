package com.example.meals.presentation

import android.app.Application
import com.example.meals.di.DaggerApplicationComponent

class MealsApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}