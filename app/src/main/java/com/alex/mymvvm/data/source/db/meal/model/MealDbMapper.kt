package com.alex.mymvvm.data.source.db.meal.model

import com.alex.mymvvm.domain.model.MealDomainModel

fun MealDbModel.toMealDomainModel(): MealDomainModel =
    MealDomainModel(id, title, imageLink, category)