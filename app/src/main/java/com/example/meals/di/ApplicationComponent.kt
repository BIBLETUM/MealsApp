package com.example.meals.di

import android.app.Application
import com.example.meals.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [ModuleViewModel::class, ModuleData::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent

    }
}