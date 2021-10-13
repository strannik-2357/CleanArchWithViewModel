package com.alex.mymvvm.domain.repositories

import com.alex.mymvvm.domain.model.MealDomainModel
import io.reactivex.rxjava3.core.Flowable

interface IMealListRepository {

    fun getMeals(category: String): Flowable<List<MealDomainModel>>

}