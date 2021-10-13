package com.alex.mymvvm.data.repository

import com.alex.mymvvm.data.source.db.meal.MealDbSource
import com.alex.mymvvm.data.source.db.meal.model.toMealDomainModel
import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.domain.repositories.IMealDetailRepository
import io.reactivex.rxjava3.core.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealDetailRepository @Inject constructor(
    private val mealDbSource: MealDbSource
) : IMealDetailRepository {

    override fun getMealDetail(id: Long): Maybe<MealDomainModel> {
        return mealDbSource.getMeal(id)
            .map { it.toMealDomainModel() }
    }

}