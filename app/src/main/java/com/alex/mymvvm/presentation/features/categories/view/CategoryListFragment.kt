package com.alex.mymvvm.presentation.features.categories.view

import alex.mymvvm.databinding.CategoryListFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.mymvvm.core.di.ComponentProvider
import com.alex.mymvvm.presentation.base.BaseFragment
import com.alex.mymvvm.presentation.features.categories.di.CategoryListFragmentComponent
import com.alex.mymvvm.presentation.features.categories.model.CategoryUIModel
import com.alex.mymvvm.presentation.features.categories.viewModel.CategoriesViewModel
import com.alex.mymvvm.presentation.features.root.RootTitleUI
import com.alex.mymvvm.presentation.features.root.RootTitle
import com.alex.mymvvm.utils.isVisible
import javax.inject.Inject

class CategoryListFragment :
    BaseFragment<CategoriesViewModel>(),
    ComponentProvider<CategoryListFragmentComponent>,
    CategoryAdapter.OnCategoryClickListener {

    @Inject
    override lateinit var viewModel: CategoriesViewModel

    override val component: CategoryListFragmentComponent by lazy {
        CategoryListFragmentComponent.create(this)
    }

    private lateinit var viewBinding: CategoryListFragmentBinding

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = CategoryListFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        component.inject(this)
        super.onViewCreated(view, savedInstanceState)

        initViews()

        viewModel.getCategoryListLiveData().observe(viewLifecycleOwner) { list ->
            categoryAdapter.setData(list)
        }
        viewModel.getCategoryListProgressLiveData().observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }
        viewModel.loadingCategoryList()

        setTitle(RootTitleUI(RootTitle.CATEGORIES))
    }

    override fun onClick(item: CategoryUIModel) {
        viewModel.onCategoryItemClick(item)
    }

    private fun initViews() {
        categoryAdapter = CategoryAdapter(this)
        viewBinding.recyclerView.adapter = categoryAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        viewBinding.progressLoading.isVisible = isLoading
    }

}