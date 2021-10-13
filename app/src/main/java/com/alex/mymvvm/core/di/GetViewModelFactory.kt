package com.alex.mymvvm.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


inline fun <VM : ViewModel> getViewModelFactory(crossinline creator: () -> VM)
        : ViewModelProvider.Factory {

    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = creator() as T

    }
}