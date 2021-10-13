package com.alex.mymvvm.presentation.features.categories.di

import com.alex.mymvvm.MyApplication
import com.alex.mymvvm.core.di.AppComponent
import com.alex.mymvvm.core.di.FragmentScope
import com.alex.mymvvm.core.di.findDependencyProvider
import com.alex.mymvvm.presentation.features.categories.view.CategoryListFragment
import dagger.BindsInstance
import dagger.Component

@FragmentScope
@Component(
    modules = [CategoriesModule::class],
    dependencies = [AppComponent::class]
)

interface CategoryListFragmentComponent {

    fun inject(fragment: CategoryListFragment)

    @FragmentScope
    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance fragment: CategoryListFragment
        ): CategoryListFragmentComponent
    }

    companion object {
        fun create(fragment: CategoryListFragment): CategoryListFragmentComponent {
            return DaggerCategoryListFragmentComponent.factory().create(
                fragment.findDependencyProvider<MyApplication>().component,
                fragment
            )
        }
    }

}