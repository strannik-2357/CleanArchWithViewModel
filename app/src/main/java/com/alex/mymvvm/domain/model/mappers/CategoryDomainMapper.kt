package com.alex.mymvvm.domain.model.mappers

import com.alex.mymvvm.domain.model.CategoryDomainModel
import com.alex.mymvvm.presentation.features.categories.model.CategoryUIModel

fun CategoryDomainModel.toUIModel(): CategoryUIModel =
    CategoryUIModel(id.toString(), title, imageUrl)
