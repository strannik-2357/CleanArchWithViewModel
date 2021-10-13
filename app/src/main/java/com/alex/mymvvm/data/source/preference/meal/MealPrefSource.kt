package com.alex.mymvvm.data.source.preference.meal

import android.content.SharedPreferences
import com.alex.mymvvm.data.source.preference.saveToPref
import javax.inject.Inject

private const val LAST_CACHING_TIME_FOR_MEALS = "last-caching-time-for-meals-"

class MealPrefSource @Inject constructor(private val pref: SharedPreferences) {

    fun getLastCachingTime(category: String): Long {
        return pref.getLong(LAST_CACHING_TIME_FOR_MEALS + category, 0L)
    }


    fun setLastCachingTime(category: String, time: Long) {
        time.saveToPref(pref, LAST_CACHING_TIME_FOR_MEALS + category)
    }


    // Есть ли смысл делать SharedPreferences через Rx ?

//    fun setLastCachingTimeCompletable(category: String, time: Long): Completable {
//        return Completable.create { emitter ->
//            time.saveToPref(pref, LAST_CACHING_TIME_FOR_MEALS + category)
//            emitter.onComplete()
//        }
//    }


}