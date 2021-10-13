package com.alex.mymvvm.data.source.net.meal.model

import com.google.gson.annotations.SerializedName

data class MealListNetModel(

    @SerializedName("meals")
    val mealList: List<MealNetModel>

)