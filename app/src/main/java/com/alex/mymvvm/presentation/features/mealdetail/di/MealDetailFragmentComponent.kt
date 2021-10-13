package com.alex.mymvvm.presentation.features.mealdetail.di

import com.alex.mymvvm.MyApplication
import com.alex.mymvvm.core.di.AppComponent
import com.alex.mymvvm.core.di.FragmentScope
import com.alex.mymvvm.core.di.findDependencyProvider
import com.alex.mymvvm.presentation.features.mealdetail.view.MealDetailFragment
import dagger.BindsInstance
import dagger.Component

@FragmentScope
@Component(
    modules = [MealDetailModule::class],
    dependencies = [AppComponent::class]
)

interface MealDetailFragmentComponent {

    fun inject(fragment: MealDetailFragment)

    @FragmentScope
    @Component.Factory
    interface Factory {
        fun create(
            component: AppComponent,
            @BindsInstance fragment: MealDetailFragment
        ): MealDetailFragmentComponent
    }

    companion object {
        fun create(fragment: MealDetailFragment): MealDetailFragmentComponent {
            return DaggerMealDetailFragmentComponent.factory().create(
                fragment.findDependencyProvider<MyApplication>().component,
                fragment
            )
        }
    }

}