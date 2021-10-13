package com.alex.mymvvm.data.repository

import com.alex.mymvvm.data.source.db.category.CategoryDbSource
import com.alex.mymvvm.data.source.db.category.model.CategoryDbModel
import com.alex.mymvvm.data.source.db.category.model.toCategoryDomainModel
import com.alex.mymvvm.data.source.net.category.CategoryNetSource
import com.alex.mymvvm.data.source.net.category.model.toCategoryDbModel
import com.alex.mymvvm.data.source.preference.category.CategoryPrefSource
import com.alex.mymvvm.domain.model.CategoryDomainModel
import com.alex.mymvvm.domain.repositories.ICategoryListRepository
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

private const val CACHING_PERIOD = 24 * 60 * 60 * 1000L

@Singleton
class CategoryListRepository @Inject constructor(
    private val categoryNetSource: CategoryNetSource,
    private val categoryDbSource: CategoryDbSource,
    private val categoryPrefSource: CategoryPrefSource

) : ICategoryListRepository {

    override fun getCategories(): Flowable<List<CategoryDomainModel>> {
        return categoryDbSource.getCategories()
            .flatMapObservable { categoryDbModels ->
                if (categoryDbModels.isEmpty()) {
                    updateCategories().toObservable()
                } else {
                    val lastCachingTime = categoryPrefSource.getLastCachingTime()

                    if (System.currentTimeMillis() - lastCachingTime > CACHING_PERIOD) {
                        Observable.just(categoryDbModels).concatWith(updateCategories())
                    } else {
                        Observable.just(categoryDbModels)
                    }
                }
            }
            .map { categoryDbModels -> categoryDbModels.map { it.toCategoryDomainModel() } }
            .toFlowable(BackpressureStrategy.LATEST)
    }

    private fun updateCategories(): Single<List<CategoryDbModel>> {
        return categoryNetSource.getCategories()
            .map { response -> response.categoryList }
            .map { categoryNetModels ->
                val categoryDbModels = categoryNetModels.map { it.toCategoryDbModel() }
                categoryDbSource.save(categoryDbModels)
                categoryPrefSource.setLastCachingTime(System.currentTimeMillis())
                categoryDbModels
            }
    }

}