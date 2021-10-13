package com.alex.mymvvm.domain.repositories

import com.alex.mymvvm.domain.model.MealDomainModel
import io.reactivex.rxjava3.core.Maybe

interface IMealDetailRepository {

    fun getMealDetail(id: Long): Maybe<MealDomainModel>

}