package com.alex.mymvvm.presentation.features.meals.view

import alex.mymvvm.databinding.MealItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel


class MealAdapter(
    private var clickListener: OnMealClickListener
) : RecyclerView.Adapter<MealViewHolder>() {

    private var data: List<MealUIModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val b = MealItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return MealViewHolder(b, clickListener, data)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun setData(newList: List<MealUIModel>) {
        val diffResult = DiffUtil.calculateDiff(MealDiffCallback(newList, data))
        diffResult.dispatchUpdatesTo(this)
        data = newList
    }

    interface OnMealClickListener {
        fun onClick(item: MealUIModel)
    }

}


