package com.alex.mymvvm.presentation.features.meals.viewModel

import com.alex.mymvvm.presentation.features.meals.view.MealListFragmentDirections
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.mymvvm.TAG
import com.alex.mymvvm.domain.model.MealDomainModel
import com.alex.mymvvm.domain.model.mappers.toUIModel
import com.alex.mymvvm.domain.usecases.meals.GetMealsUseCase
import com.alex.mymvvm.presentation.base.BaseViewModel
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MealsViewModel(private val getMealListUseCase: GetMealsUseCase) :
    BaseViewModel() {

    val category: String by lazy {
        getArguments()?.getString("title") ?: ""
    }

    private val mealListLiveData = MutableLiveData<List<MealUIModel>>()
    private val mealListProgressLiveData = MutableLiveData<Boolean>()

    fun getMealListLiveData(): LiveData<List<MealUIModel>> = mealListLiveData
    fun getMealListProgressLiveData(): LiveData<Boolean> = mealListProgressLiveData

    fun loadMealList() {

        val observable = getMealListUseCase(category)

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { mealListProgressLiveData.value = true }
            .doOnEach { mealListProgressLiveData.value = false }
            .subscribe(
                this::handleResults,
                this::handleError
            )
            .autoDispose()
    }


    fun onMealItemClick(item: MealUIModel) {

        // Google Safe Args
        // https://developer.android.com/guide/navigation/navigation-pass-data
        val toMealDetailById = MealListFragmentDirections
            .actionMealListToMealDetail(item.id)

        navigate(toMealDetailById)
    }

    private fun handleResults(meals: List<MealDomainModel>) {
        if (meals.isNotEmpty()) {
            mealListLiveData.value = meals.map { it.toUIModel() }
        } else {
            handleError(Throwable("Нет данных!"))
        }
    }

    private fun handleError(t: Throwable) {
        Log.e(TAG, "handleError: ", t)
    }

}

