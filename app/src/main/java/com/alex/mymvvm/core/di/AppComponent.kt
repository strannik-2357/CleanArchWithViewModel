package com.alex.mymvvm.core.di


import android.content.Context
import com.alex.mymvvm.data.repository.RepositoryModule
import com.alex.mymvvm.data.source.db.di.DbSourceModule
import com.alex.mymvvm.data.source.net.di.NetSourceModule
import com.alex.mymvvm.data.source.preference.di.PreferenceSourceModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        NetSourceModule::class,
        DbSourceModule::class,
        PreferenceSourceModule::class
    ]
)
interface AppComponent : DataDependenciesProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance ctx: Context): AppComponent
    }

}