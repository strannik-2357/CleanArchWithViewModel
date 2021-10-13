package com.alex.mymvvm.core.di

interface ComponentProvider<T> {
    val component: T
}