package com.alex.mymvvm.data.source.net.api

import com.alex.mymvvm.data.source.net.meal.model.MealListNetModel
import io.reactivex.rxjava3.core.Single


import retrofit2.http.GET
import retrofit2.http.Query


interface MealApi {

    @GET("filter.php")
    fun getMealListResponse(@Query("c") category: String): Single<MealListNetModel>

}