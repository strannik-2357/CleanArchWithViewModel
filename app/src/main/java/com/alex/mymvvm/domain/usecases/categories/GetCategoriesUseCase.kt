package com.alex.mymvvm.domain.usecases.categories

import com.alex.mymvvm.domain.model.CategoryDomainModel
import com.alex.mymvvm.domain.repositories.ICategoryListRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val categoryListRepository: ICategoryListRepository) {

    operator fun invoke(): Flowable<List<CategoryDomainModel>> =
        categoryListRepository.getCategories()

}