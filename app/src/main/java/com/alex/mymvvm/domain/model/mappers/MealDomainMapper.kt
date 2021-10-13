package com.alex.mymvvm.domain.model.mappers

import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel

fun MealDomainModel.toUIModel(): MealUIModel =
    MealUIModel(id, title, imageUrl)
