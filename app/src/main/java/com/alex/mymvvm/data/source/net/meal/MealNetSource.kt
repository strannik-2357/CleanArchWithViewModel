package com.alex.mymvvm.data.source.net.meal


import com.alex.mymvvm.data.source.net.api.MealApi
import com.alex.mymvvm.data.source.net.meal.model.MealListNetModel
import io.reactivex.rxjava3.core.Single

class MealNetSource(private val api: MealApi) {

    fun getMeals(category: String): Single<MealListNetModel> {
        return api.getMealListResponse(category)
    }

}





