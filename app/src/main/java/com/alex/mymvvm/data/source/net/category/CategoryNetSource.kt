package com.alex.mymvvm.data.source.net.category


import com.alex.mymvvm.data.source.net.api.CategoryApi
import com.alex.mymvvm.data.source.net.category.model.CategoryListNetModel
import io.reactivex.rxjava3.core.Single

class CategoryNetSource(private val api: CategoryApi) {

    fun getCategories(): Single<CategoryListNetModel> {
        return api.getCategoryListResponse()
    }

}





