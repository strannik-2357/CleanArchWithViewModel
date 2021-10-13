package com.alex.mymvvm.core.di

import com.alex.mymvvm.domain.repositories.ICategoryListRepository
import com.alex.mymvvm.domain.repositories.IMealDetailRepository
import com.alex.mymvvm.domain.repositories.IMealListRepository

interface DataDependenciesProvider {
    fun categoryListRepository(): ICategoryListRepository
    fun mealListRepository(): IMealListRepository
    fun mealDetailRepository(): IMealDetailRepository
}