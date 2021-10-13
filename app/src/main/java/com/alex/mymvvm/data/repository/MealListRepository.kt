package com.alex.mymvvm.data.repository

import com.alex.mymvvm.data.source.db.meal.MealDbSource
import com.alex.mymvvm.data.source.db.meal.model.MealDbModel
import com.alex.mymvvm.data.source.db.meal.model.toMealDomainModel
import com.alex.mymvvm.data.source.net.meal.MealNetSource
import com.alex.mymvvm.data.source.net.meal.model.toMealDbModel
import com.alex.mymvvm.data.source.preference.meal.MealPrefSource
import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.domain.repositories.IMealListRepository
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

private const val CACHING_PERIOD = 1 * 30 * 1000L

@Singleton
class MealListRepository @Inject constructor(
    private val mealNetSource: MealNetSource,
    private val mealDbSource: MealDbSource,
    private val mealPrefSource: MealPrefSource

) : IMealListRepository {

    override fun getMeals(category: String): Flowable<List<MealDomainModel>> {

        return mealDbSource.getMeals(category)
            .flatMapObservable { mealDbModels ->
                if (mealDbModels.isEmpty()) {
                    updateMeals(category).toObservable()
                } else {
                    val lastCachingTime = mealPrefSource.getLastCachingTime(category)
                    if ((System.currentTimeMillis() - lastCachingTime) > CACHING_PERIOD) {
                        Observable.just(mealDbModels).concatWith(updateMeals(category))
                    } else {
                        Observable.just(mealDbModels)
                    }
                }
            }
            .map { mealDbModels -> mealDbModels.map { it.toMealDomainModel() } }
            .toFlowable(BackpressureStrategy.LATEST)
    }

    private fun updateMeals(category: String): Single<List<MealDbModel>> {
        return mealNetSource.getMeals(category)
            .map { response -> response.mealList }
            .map { mealNetModels ->
                val mealDbModels = mealNetModels.map { it.toMealDbModel(category) }
                mealDbSource.save(category, mealDbModels)
                mealPrefSource.setLastCachingTime(category, System.currentTimeMillis())
                mealDbModels
            }
    }
}