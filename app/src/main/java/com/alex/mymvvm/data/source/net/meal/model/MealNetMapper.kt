package com.alex.mymvvm.data.source.net.meal.model

import com.alex.mymvvm.data.source.db.meal.model.MealDbModel

fun MealNetModel.toMealDbModel(category: String): MealDbModel =
    MealDbModel(id.toLong(), title, thumb, category)