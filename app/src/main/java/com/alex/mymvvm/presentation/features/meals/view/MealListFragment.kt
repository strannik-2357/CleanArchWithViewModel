package com.alex.mymvvm.presentation.features.meals.view

import alex.mymvvm.databinding.MealListFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.mymvvm.core.di.ComponentProvider
import com.alex.mymvvm.presentation.base.BaseFragment
import com.alex.mymvvm.presentation.features.meals.di.MealListFragmentComponent
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel
import com.alex.mymvvm.presentation.features.meals.viewModel.MealsViewModel
import com.alex.mymvvm.presentation.features.root.RootTitleUI
import com.alex.mymvvm.presentation.features.root.RootTitle
import com.alex.mymvvm.utils.isVisible
import javax.inject.Inject

class MealListFragment : BaseFragment<MealsViewModel>(),
    ComponentProvider<MealListFragmentComponent>,
    MealAdapter.OnMealClickListener {

    @Inject
    override lateinit var viewModel: MealsViewModel

    override val component: MealListFragmentComponent by lazy {
        MealListFragmentComponent.create(this)
    }

    private lateinit var viewBinding: MealListFragmentBinding

    private lateinit var mealAdapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = MealListFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        component.inject(this)
        super.onViewCreated(view, savedInstanceState)

        initViews()

        viewModel.getMealListLiveData().observe(viewLifecycleOwner) { list ->
            mealAdapter.setData(list)
        }
        viewModel.getMealListProgressLiveData().observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

        viewModel.loadMealList()

        setTitle(RootTitleUI(RootTitle.MEALS, text = viewModel.category))
    }

    override fun onClick(item: MealUIModel) {
        viewModel.onMealItemClick(item)
    }


    private fun initViews() {
        mealAdapter = MealAdapter(this)
        viewBinding.recyclerView.adapter = mealAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        viewBinding.progressLoading.isVisible = isLoading
    }

}