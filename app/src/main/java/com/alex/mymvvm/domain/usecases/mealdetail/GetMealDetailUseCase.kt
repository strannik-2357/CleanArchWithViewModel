package com.alex.mymvvm.domain.usecases.mealdetail

import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.domain.repositories.IMealDetailRepository
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class GetMealDetailUseCase @Inject constructor(private val mealDetailRepository: IMealDetailRepository) {

    operator fun invoke(mealId: Long): Maybe<MealDomainModel> =
        mealDetailRepository.getMealDetail(mealId)

}