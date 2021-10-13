package com.alex.mymvvm.data.source.db.category.model

import com.alex.mymvvm.domain.model.CategoryDomainModel

fun CategoryDbModel.toCategoryDomainModel(): CategoryDomainModel =
    CategoryDomainModel(id, title, imageLink, description)