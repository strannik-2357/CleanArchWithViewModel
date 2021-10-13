package com.alex.mymvvm.presentation.features.mealdetail.view

import alex.mymvvm.databinding.MealDetailFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.alex.mymvvm.core.di.ComponentProvider
import com.alex.mymvvm.presentation.base.BaseFragment
import com.alex.mymvvm.presentation.features.mealdetail.di.MealDetailFragmentComponent
import com.alex.mymvvm.presentation.features.mealdetail.viewModel.MealDetailViewModel
import com.alex.mymvvm.presentation.features.meals.model.MealUIModel
import com.alex.mymvvm.presentation.features.root.RootTitleUI
import com.alex.mymvvm.presentation.features.root.RootTitle
import javax.inject.Inject

class MealDetailFragment : BaseFragment<MealDetailViewModel>(),
    ComponentProvider<MealDetailFragmentComponent> {

    @Inject
    override lateinit var viewModel: MealDetailViewModel

    override val component: MealDetailFragmentComponent by lazy {
        MealDetailFragmentComponent.create(this)
    }

    private lateinit var viewBinding: MealDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = MealDetailFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        component.inject(this)
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMealDetailLiveData().observe(viewLifecycleOwner, { mealUIModel ->
            setViews(mealUIModel)
        })

        viewModel.loadMealDetail()

        setTitle(RootTitleUI(RootTitle.MEAL_DETAIL))
    }

    private fun setViews(mealUIModel: MealUIModel) {
        viewBinding.tvTitle.text = mealUIModel.title
        Glide.with(viewBinding.image)
            .load(mealUIModel.url)
            .into(viewBinding.image)
    }

}