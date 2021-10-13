package com.alex.mymvvm.data.repository

import com.alex.mymvvm.domain.repositories.ICategoryListRepository
import com.alex.mymvvm.domain.repositories.IMealDetailRepository
import com.alex.mymvvm.domain.repositories.IMealListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun getCategoryListRepository(
        categoryRepository: CategoryListRepository
    ): ICategoryListRepository

    @Singleton
    @Binds
    abstract fun getMealListRepository(
        mealListRepository: MealListRepository
    ): IMealListRepository

    @Singleton
    @Binds
    abstract fun getMealDetailRepository(
        mealDetailRepository: MealDetailRepository
    ): IMealDetailRepository

}