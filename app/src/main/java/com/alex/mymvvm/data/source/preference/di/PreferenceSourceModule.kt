package com.alex.mymvvm.data.source.preference.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class PreferenceSourceModule {

    @Provides
    fun getSharedPreferences(ctx: Context): SharedPreferences {
        return ctx.getSharedPreferences("", MODE_PRIVATE)
    }


}