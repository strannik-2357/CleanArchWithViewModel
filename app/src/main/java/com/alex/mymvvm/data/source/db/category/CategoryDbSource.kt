package com.alex.mymvvm.data.source.db.category

import com.alex.mymvvm.data.source.db.category.model.CategoryDbModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CategoryDbSource @Inject constructor(private val dao: CategoryDao) {

    fun getCategories(): Single<List<CategoryDbModel>> {
        return dao.getAll()  
    }

    fun save(list: List<CategoryDbModel>) {
        dao.deleteAll()
        dao.insertAll(list)
    }

}