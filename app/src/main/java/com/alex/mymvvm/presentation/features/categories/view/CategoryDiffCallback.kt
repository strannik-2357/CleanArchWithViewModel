package com.alex.mymvvm.presentation.features.categories.view

import androidx.recyclerview.widget.DiffUtil
import com.alex.mymvvm.presentation.features.categories.model.CategoryUIModel

class CategoryDiffCallback(
    private var newMeals: List<CategoryUIModel>,
    private var oldMeals: List<CategoryUIModel>
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