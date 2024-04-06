package com.example.meals.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MealDbModel::class, CategoryDbModel::class],
    version = 3,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        private const val DB_NAME = "main.db"
        private var db: AppDataBase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDataBase {
            synchronized(LOCK) {
                db?.let { return it }

                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun mealsDao(): MealsDao
}