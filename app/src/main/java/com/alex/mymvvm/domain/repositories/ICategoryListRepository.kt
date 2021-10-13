package com.alex.mymvvm.domain.repositories

import com.alex.mymvvm.domain.model.CategoryDomainModel
import io.reactivex.rxjava3.core.Flowable

interface ICategoryListRepository {

    fun getCategories(): Flowable<List<CategoryDomainModel>>

}