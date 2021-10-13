package com.alex.mymvvm.data.source.net.category.model

import com.alex.mymvvm.data.source.db.category.model.CategoryDbModel

fun CategoryNetModel.toCategoryDbModel(): CategoryDbModel =
    CategoryDbModel(id.toLong(), title, thumb, description)
