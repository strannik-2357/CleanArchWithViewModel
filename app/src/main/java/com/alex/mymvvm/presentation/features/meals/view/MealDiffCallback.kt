package com.alex.mymvvm.presentation.features.meals.view

import androidx.recyclerview.widget.DiffUtil
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel

class MealDiffCallback(
    private var newMeals: List<MealUIModel>,
    private var oldMeals: List<MealUIModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldMeals.size

    override fun getNewListSize(): Int = newMeals.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMeals[oldItemPosition].id == newMeals[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMeals[oldItemPosition] == newMeals[newItemPosition]
    }


}