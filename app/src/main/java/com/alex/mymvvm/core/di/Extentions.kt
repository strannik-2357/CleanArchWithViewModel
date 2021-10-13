package com.alex.mymvvm.core.di

import androidx.fragment.app.Fragment
import java.lang.IllegalArgumentException


inline fun <reified T> Fragment.findDependencyProvider(): T {

    var parentFragment: Fragment? = this
    while (parentFragment != null) {
        if (parentFragment is T) return parentFragment
        parentFragment = parentFragment.parentFragment
    }

    if (this.activity is T) {
        return this.activity as T
    }

    val app = this.activity?.application
    if (app is T) {
        return app
    } else {
        throw IllegalArgumentException(
            "No ${T::class.java.simpleName} was found for ${this.javaClass.simpleName}"
        )
    }
}
