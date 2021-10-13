package com.alex.mymvvm.data.source.preference.category

import android.content.SharedPreferences
import com.alex.mymvvm.data.source.preference.saveToPref
import javax.inject.Inject

private const val LAST_CACHING_TIME_FOR_CATEGORIES = "last-caching-time-for-categories"

class CategoryPrefSource @Inject constructor(private val pref: SharedPreferences) {

    fun getLastCachingTime(): Long = pref.getLong(LAST_CACHING_TIME_FOR_CATEGORIES, 0L)

    fun setLastCachingTime(time: Long) {
        time.saveToPref(pref, LAST_CACHING_TIME_FOR_CATEGORIES)
    }
}