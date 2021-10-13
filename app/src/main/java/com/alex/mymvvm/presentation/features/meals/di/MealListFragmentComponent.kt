package com.alex.mymvvm.presentation.features.meals.di

import com.alex.mymvvm.MyApplication
import com.alex.mymvvm.core.di.AppComponent
import com.alex.mymvvm.core.di.FragmentScope
import com.alex.mymvvm.core.di.findDependencyProvider
import com.alex.mymvvm.presentation.features.meals.view.MealListFragment
import dagger.BindsInstance
import dagger.Component

@FragmentScope
@Component(
    modules = [MealsModule::class],
    dependencies = [AppComponent::class]
)

interface MealListFragmentComponent {

    fun inject(fragment: MealListFragment)

    @FragmentScope
    @Component.Factory
    interface Factory {
        fun create(
            component: AppComponent,
            @BindsInstance fragment: MealListFragment
        ): MealListFragmentComponent
    }

    companion object {
        fun create(fragment: MealListFragment): MealListFragmentComponent {
            return DaggerMealListFragmentComponent.factory().create(
                fragment.findDependencyProvider<MyApplication>().component,
                fragment
            )
        }
    }

}