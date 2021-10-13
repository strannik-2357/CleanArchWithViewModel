package com.alex.mymvvm.presentation.features.categories.view

import alex.mymvvm.databinding.CategoryItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alex.mymvvm.presentation.features.categories.model.CategoryUIModel


class CategoryAdapter(
    private var clickListener: OnCategoryClickListener
) : RecyclerView.Adapter<CategoryViewHolder>() {

    private var data: List<CategoryUIModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val b: CategoryItemBinding = CategoryItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return CategoryViewHolder(b, clickListener, data)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


    fun setData(newList: List<CategoryUIModel>) {
        val diffResult = DiffUtil.calculateDiff(CategoryDiffCallback(newList, data))
        diffResult.dispatchUpdatesTo(this)
        data = newList
    }

    interface OnCategoryClickListener {
        fun onClick(item: CategoryUIModel)
    }

}


