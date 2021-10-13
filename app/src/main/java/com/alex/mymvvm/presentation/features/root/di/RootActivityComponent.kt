package com.alex.mymvvm.presentation.features.root.di

import com.alex.mymvvm.core.di.ActivityScope
import com.alex.mymvvm.presentation.features.root.view.RootActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(
    modules = [RootActivityModule::class]
)
interface RootActivityComponent {

    fun inject(activity: RootActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: RootActivity): RootActivityComponent
    }

    companion object {
        fun create(activity: RootActivity): RootActivityComponent {
            return DaggerRootActivityComponent.factory().create(activity)
        }
    }

}