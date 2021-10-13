package com.alex.mymvvm.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.mymvvm.TAG
import com.alex.mymvvm.presentation.features.root.RootTitleUI
import com.alex.mymvvm.presentation.features.root.view.RootActivity

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    abstract var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Из статьи Using Navigation Architecture Component
        // https://medium.com/google-developer-experts/using-navigation-architecture-component-in-a-large-banking-app-ac84936a42c2

        if (savedInstanceState == null) {
            viewModel.setArguments(arguments)
        }

        viewModel.navigationCommands.observe(viewLifecycleOwner) { command ->
            when (command) {
                is NavigationCommand.To ->
                    findNavController().navigate(command.directions)

                is NavigationCommand.Back ->
                    Log.d(TAG, "Navigation $command в этом проекте не используется")

                is NavigationCommand.BackTo ->
                    Log.d(TAG, "Navigation $command в этом проекте не используется")

                NavigationCommand.ToRoot ->
                    Log.d(TAG, "Navigation $command в этом проекте не используется")
            }
        }

        //

    }

    protected fun setTitle(title: RootTitleUI) {
        if (activity is RootActivity) {
            (activity as RootActivity).selectTitle(title)
        }
    }
}