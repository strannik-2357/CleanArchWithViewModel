package com.alex.mymvvm.data.source.net.di

import com.alex.mymvvm.data.source.net.api.CategoryApi
import com.alex.mymvvm.data.source.net.api.MealApi
import com.alex.mymvvm.data.source.net.category.CategoryNetSource
import com.alex.mymvvm.data.source.net.meal.MealNetSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val HOST = "https://www.themealdb.com/api/json/v1/1/"

@Module
class NetSourceModule {

    @Provides
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    fun getCategoryApi(retrofit: Retrofit): CategoryApi = retrofit.create(CategoryApi::class.java)

    @Provides
    fun getCategoryNetSource(categoryApi: CategoryApi) = CategoryNetSource(categoryApi)


    @Provides
    fun getMealApi(retrofit: Retrofit): MealApi = retrofit.create(MealApi::class.java)

    @Provides
    fun getMealNetSource(mealApi: MealApi) = MealNetSource(mealApi)


}