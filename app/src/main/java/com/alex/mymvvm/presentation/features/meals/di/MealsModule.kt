package com.alex.mymvvm.presentation.features.meals.di

import androidx.lifecycle.ViewModelProvider
import com.alex.mymvvm.core.di.getViewModelFactory
import com.alex.mymvvm.domain.usecases.meals.GetMealsUseCase
import com.alex.mymvvm.presentation.features.meals.view.MealListFragment
import com.alex.mymvvm.presentation.features.meals.viewModel.MealsViewModel
import dagger.Module
import dagger.Provides

@Module
class MealsModule {

    @Provides
    fun provideMealsViewModelFactory(getMealsUseCase: GetMealsUseCase)
            : ViewModelProvider.Factory =
        getViewModelFactory {
            MealsViewModel(getMealsUseCase)
        }

    @Provides
    fun provideMealsViewModel(
        factory: ViewModelProvider.Factory,
        fragment: MealListFragment,
    ): MealsViewModel =
        ViewModelProvider(fragment, factory)[MealsViewModel::class.java]

}