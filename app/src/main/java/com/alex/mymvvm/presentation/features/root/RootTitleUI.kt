package com.alex.mymvvm.presentation.features.root

enum class RootTitle { CATEGORIES, MEALS, MEAL_DETAIL }

data class RootTitleUI(val type: RootTitle, val text: String = "")
