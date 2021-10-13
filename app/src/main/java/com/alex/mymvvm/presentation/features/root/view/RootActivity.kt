package com.alex.mymvvm.presentation.features.root.view

import alex.mymvvm.databinding.RootActivityBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alex.mymvvm.core.di.ComponentProvider
import com.alex.mymvvm.presentation.features.root.RootTitleUI
import com.alex.mymvvm.presentation.features.root.RootTitle
import com.alex.mymvvm.presentation.features.root.di.RootActivityComponent
import com.alex.mymvvm.presentation.features.root.viewmodel.RootViewModel
import javax.inject.Inject


class RootActivity : AppCompatActivity(), ComponentProvider<RootActivityComponent> {

    @Inject
    lateinit var viewModel: RootViewModel

    override val component: RootActivityComponent by lazy {
        RootActivityComponent.create(this)
    }

    private val viewBinding by lazy {
        RootActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        setContentView(viewBinding.root)

        // как пример, пока не используется, вся движуха во фрагментах
        viewModel.getTitleLiveData().observe(this) { selectTitle(it) }

    }

    fun selectTitle(titleUI: RootTitleUI) {
        when (titleUI.type) {
            RootTitle.CATEGORIES -> this.title = "Категории"
            RootTitle.MEALS -> this.title = titleUI.text
            RootTitle.MEAL_DETAIL -> this.title = "Описание"
        }
    }

}