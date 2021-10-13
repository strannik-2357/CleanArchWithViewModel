package com.alex.mymvvm.presentation.features.root.di

import androidx.lifecycle.ViewModelProvider
import com.alex.mymvvm.core.di.getViewModelFactory
import com.alex.mymvvm.presentation.features.root.view.RootActivity
import com.alex.mymvvm.presentation.features.root.viewmodel.RootViewModel
import dagger.Module
import dagger.Provides

@Module
class RootActivityModule {

    @Provides
    fun provideComponentViewModelFactory(): ViewModelProvider.Factory =
        getViewModelFactory {
            RootViewModel()
        }

    @Provides
    fun provideComponentViewModel(
        factory: ViewModelProvider.Factory,
        activity: RootActivity
    ): RootViewModel =
        ViewModelProvider(
            activity,
            factory
        )[RootViewModel::class.java]

}