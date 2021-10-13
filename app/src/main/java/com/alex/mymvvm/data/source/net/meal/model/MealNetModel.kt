package com.alex.mymvvm.data.source.net.meal.model

import com.google.gson.annotations.SerializedName

data class MealNetModel(

    @SerializedName("idMeal")
    val id: String,

    @SerializedName("strMeal")
    val title: String,

    @SerializedName("strMealThumb")
    val thumb: String,
)