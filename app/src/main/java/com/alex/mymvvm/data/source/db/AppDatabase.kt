package com.alex.mymvvm.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.mymvvm.data.source.db.category.CategoryDao
import com.alex.mymvvm.data.source.db.category.model.CategoryDbModel
import com.alex.mymvvm.data.source.db.meal.MealDao
import com.alex.mymvvm.data.source.db.meal.model.MealDbModel


@Database(
    entities = [CategoryDbModel::class, MealDbModel::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun mealDao(): MealDao
}



