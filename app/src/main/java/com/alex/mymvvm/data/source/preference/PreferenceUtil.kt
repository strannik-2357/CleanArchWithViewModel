package com.alex.mymvvm.data.source.preference

import android.content.SharedPreferences


fun Long.saveToPref(pref: SharedPreferences, key: String) {
    val editor = pref.edit()
    editor.putLong(key, this)
    editor.apply()
}
