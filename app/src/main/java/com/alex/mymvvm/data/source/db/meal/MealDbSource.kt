package com.alex.mymvvm.data.source.db.meal

import com.alex.mymvvm.data.source.db.meal.model.MealDbModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MealDbSource @Inject constructor(private val dao: MealDao) {

    fun getMeals(category: String): Single<List<MealDbModel>> = dao.getAllByCategory(category)

    fun save(category: String, list: List<MealDbModel>) {
        dao.deleteMealsByCategory(category)
        dao.insertAll(list)
    }

    fun getMeal(id: Long): Maybe<MealDbModel> = dao.getMeal(id)

}