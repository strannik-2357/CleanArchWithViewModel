package com.alex.mymvvm.presentation.features.mealdetail.di

import androidx.lifecycle.ViewModelProvider
import com.alex.mymvvm.core.di.getViewModelFactory
import com.alex.mymvvm.domain.usecases.mealdetail.GetMealDetailUseCase
import com.alex.mymvvm.presentation.features.mealdetail.view.MealDetailFragment
import com.alex.mymvvm.presentation.features.mealdetail.viewModel.MealDetailViewModel
import dagger.Module
import dagger.Provides

@Module
class MealDetailModule {

    @Provides
    fun provideMealDetailViewModelFactory(
        getMealDetailUseCase: GetMealDetailUseCase
    ): ViewModelProvider.Factory =
        getViewModelFactory {
            MealDetailViewModel(getMealDetailUseCase)
        }

    @Provides
    fun provideMealDetailViewModel(
        factory: ViewModelProvider.Factory,
        fragment: MealDetailFragment
    ): MealDetailViewModel =
        ViewModelProvider(fragment, factory)[MealDetailViewModel::class.java]

}