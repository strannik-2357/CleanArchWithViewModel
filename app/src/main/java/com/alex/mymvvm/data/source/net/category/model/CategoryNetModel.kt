package com.alex.mymvvm.data.source.net.category.model

import com.google.gson.annotations.SerializedName

data class CategoryNetModel(

    @SerializedName("idCategory")
    val id: String,

    @SerializedName("strCategory")
    val title: String,

    @SerializedName("strCategoryThumb")
    val thumb: String,

    @SerializedName("strCategoryDescription")
    val description: String
)