package com.alex.mymvvm.domain.usecases.meals

import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.domain.repositories.IMealListRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(private val mealListRepository: IMealListRepository) {

    operator fun invoke(category: String): Flowable<List<MealDomainModel>> =
        mealListRepository.getMeals(category)

}