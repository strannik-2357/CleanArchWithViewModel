package com.alex.mymvvm.presentation.base

import androidx.navigation.NavDirections

// Из статьи Using Navigation Architecture Component
// https://medium.com/google-developer-experts/using-navigation-architecture-component-in-a-large-banking-app-ac84936a42c2

sealed class NavigationCommand {

    data class To(val directions: NavDirections) : NavigationCommand()

    // пока не используется
    object Back : NavigationCommand()

    // пока не используется
    data class BackTo(val destinationId: Int) : NavigationCommand()

    // пока не используется
    object ToRoot : NavigationCommand()
}
