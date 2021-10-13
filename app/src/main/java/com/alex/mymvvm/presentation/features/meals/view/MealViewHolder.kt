package com.alex.mymvvm.presentation.features.meals.view

import alex.mymvvm.databinding.MealItemBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel

class MealViewHolder(
    private val binding: MealItemBinding,
    onClickListener: MealAdapter.OnMealClickListener,
    data: List<MealUIModel>
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.itemRoot.setOnClickListener { onClickListener.onClick(data[adapterPosition]) }
    }

    fun bind(category: MealUIModel) {
        binding.itemTvTitle.text = category.title

        Glide.with(binding.itemImg)
            .load(category.url)
            .into(binding.itemImg)
    }

}