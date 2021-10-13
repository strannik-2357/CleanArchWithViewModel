package com.alex.mymvvm.presentation.features.categories.viewModel

import com.alex.mymvvm.presentation.features.categories.view.CategoryListFragmentDirections
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.mymvvm.TAG
import com.alex.mymvvm.presentation.features.categories.model.CategoryUIModel
import com.alex.mymvvm.domain.model.CategoryDomainModel
import com.alex.mymvvm.domain.model.mappers.toUIModel
import com.alex.mymvvm.domain.usecases.categories.GetCategoriesUseCase
import com.alex.mymvvm.presentation.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CategoriesViewModel(private val getCategoriesUseCase: GetCategoriesUseCase) :
    BaseViewModel() {

    private val categoryListLiveData = MutableLiveData<List<CategoryUIModel>>()
    private val categoryListProgressLiveData = MutableLiveData<Boolean>()

    fun getCategoryListLiveData(): LiveData<List<CategoryUIModel>> = categoryListLiveData
    fun getCategoryListProgressLiveData(): LiveData<Boolean> = categoryListProgressLiveData

    fun loadingCategoryList() {

        val observable = getCategoriesUseCase()

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { categoryListProgressLiveData.value = true }
            .doOnEach { categoryListProgressLiveData.value = false }
            .subscribe(
                this::handleResults,
                this::handleError
            )
            .autoDispose()
    }

    private fun handleResults(categories: List<CategoryDomainModel>) {
        if (categories.isNotEmpty()) {
            categoryListLiveData.value = categories.map { it.toUIModel() }
        } else {
            handleError(Throwable("Нет данных!"))
        }
    }

    private fun handleError(t: Throwable) {
        Log.e(TAG, "handleError: ", t)
    }

    fun onCategoryItemClick(item: CategoryUIModel) {
        // Google Safe Args
        // https://developer.android.com/guide/navigation/navigation-pass-data
        val toMealListByCategory = CategoryListFragmentDirections
            .actionCategoryListToMealList(item.title)

        navigate(toMealListByCategory)
    }


}

