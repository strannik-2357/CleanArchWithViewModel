package com.alex.mymvvm.data.source.net.api

import com.alex.mymvvm.data.source.net.category.model.CategoryListNetModel
import io.reactivex.rxjava3.core.Single


import retrofit2.http.GET


interface CategoryApi {

    @GET("categories.php")
    fun getCategoryListResponse(): Single<CategoryListNetModel>

}