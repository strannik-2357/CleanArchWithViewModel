package com.alex.mymvvm.presentation.features.root.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel
import com.alex.mymvvm.presentation.features.root.RootTitleUI

class RootViewModel : ViewModel() {

    private val titleLiveData = MutableLiveData<RootTitleUI>()

    fun getTitleLiveData(): LiveData<RootTitleUI> = titleLiveData

    // не используется
    fun setTitle(title: RootTitleUI) {
        titleLiveData.value = title
    }

}

