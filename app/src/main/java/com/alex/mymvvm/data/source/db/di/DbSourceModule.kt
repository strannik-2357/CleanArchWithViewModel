package com.alex.mymvvm.data.source.db.di

import android.content.Context
import androidx.room.Room
import com.alex.mymvvm.data.source.db.AppDatabase
import com.alex.mymvvm.data.source.db.category.CategoryDao
import com.alex.mymvvm.data.source.db.meal.MealDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DbSourceModule {

    private lateinit var appDatabase: AppDatabase

    @Singleton
    @Provides
    fun getDatabase(ctx: Context): AppDatabase {
        if (!this::appDatabase.isInitialized) {
            appDatabase = Room.databaseBuilder(ctx, AppDatabase::class.java, "db-1").build()
        }

        return appDatabase
    }

    @Singleton
    @Provides
    fun getCategoryDao(db: AppDatabase): CategoryDao = db.categoryDao()

    @Singleton
    @Provides
    fun getMealDao(db: AppDatabase): MealDao = db.mealDao()

}