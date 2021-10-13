package com.alex.mymvvm.presentation.features.categories.view

import alex.mymvvm.databinding.CategoryItemBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alex.mymvvm.presentation.features.categories.model.CategoryUIModel

class CategoryViewHolder(
    private val binding: CategoryItemBinding,
    onClickListener: CategoryAdapter.OnCategoryClickListener,
    data: List<CategoryUIModel>
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.itemRoot.setOnClickListener { onClickListener.onClick(data[adapterPosition]) }
    }

    fun bind(category: CategoryUIModel) {
        binding.itemTvTitle.text = category.title

        Glide.with(binding.itemImg)
            .load(category.url)
            .into(binding.itemImg)
    }


}