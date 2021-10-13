package com.alex.mymvvm.presentation.features.mealdetail.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.mymvvm.TAG
import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.domain.model.mappers.toUIModel
import com.alex.mymvvm.domain.usecases.mealdetail.GetMealDetailUseCase
import com.alex.mymvvm.presentation.base.BaseViewModel
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MealDetailViewModel(private val getMealDetailUseCase: GetMealDetailUseCase) :
    BaseViewModel() {

    private val mealId: Long by lazy {
        getArguments()?.getLong("id") ?: 0L
    }

    private val mealDetailLiveData = MutableLiveData<MealUIModel>()

    fun getMealDetailLiveData(): LiveData<MealUIModel> = mealDetailLiveData

    fun loadMealDetail() {

        val observable = getMealDetailUseCase(mealId)

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::handleResults,
                this::handleError
            )
            .autoDispose()
    }

    private fun handleResults(meal: MealDomainModel) {
        mealDetailLiveData.value = meal.toUIModel()
    }

    private fun handleError(t: Throwable) {
        Log.e(TAG, "handleError: ", t)
    }

}

