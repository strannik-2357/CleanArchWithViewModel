package com.alex.mymvvm.presentation.features.categories.di

import androidx.lifecycle.ViewModelProvider
import com.alex.mymvvm.core.di.getViewModelFactory
import com.alex.mymvvm.domain.usecases.categories.GetCategoriesUseCase
import com.alex.mymvvm.presentation.features.categories.view.CategoryListFragment
import com.alex.mymvvm.presentation.features.categories.viewModel.CategoriesViewModel
import dagger.Module
import dagger.Provides

@Module
class CategoriesModule {

    @Provides
    fun provideComponentViewModelFactory(
        getCategoriesUseCase: GetCategoriesUseCase
    ): ViewModelProvider.Factory =
        getViewModelFactory {
            CategoriesViewModel(getCategoriesUseCase)
        }

    @Provides
    fun provideComponentViewModel(
        factory: ViewModelProvider.Factory,
        fragment: CategoryListFragment
    ): CategoriesViewModel =
        ViewModelProvider(fragment, factory)[CategoriesViewModel::class.java]
}