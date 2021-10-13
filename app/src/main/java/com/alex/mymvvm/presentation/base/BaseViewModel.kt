package com.alex.mymvvm.presentation.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val disposables: CompositeDisposable by lazy { CompositeDisposable() }


    val navigationCommands = SingleLiveEvent<NavigationCommand>()
    private var arguments: Bundle? = null


    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    protected fun <D : Disposable> D.autoDispose() {
        disposables.add(this)
    }

    protected fun Disposable.earlyDispose() {
        disposables.remove(this)
    }


    // Из статьи Using Navigation Architecture Component
    // https://medium.com/google-developer-experts/using-navigation-architecture-component-in-a-large-banking-app-ac84936a42c2

    protected fun navigate(directions: NavDirections) {
        navigationCommands.postValue(NavigationCommand.To(directions))
    }

    fun setArguments(arguments: Bundle?) {
        this.arguments = arguments
    }

    protected fun getArguments() = arguments

    //

}