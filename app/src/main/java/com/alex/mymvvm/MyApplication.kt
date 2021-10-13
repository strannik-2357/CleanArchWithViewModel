package com.alex.mymvvm

import android.app.Application
import com.alex.mymvvm.core.di.AppComponent
import com.alex.mymvvm.core.di.ComponentProvider
import com.alex.mymvvm.core.di.DaggerAppComponent

const val TAG = "MVVM"

open class MyApplication :
    Application(),
    ComponentProvider<AppComponent>
{

    override val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}