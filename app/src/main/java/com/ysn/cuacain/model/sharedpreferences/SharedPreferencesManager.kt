/*
 * Created by YSN Studio on 5/20/18 11:46 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 7:45 PM
 */

package com.ysn.cuacain.model.sharedpreferences

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        const val LAST_LATITUDE = "last_latitude"
        const val LAST_LONGITUDE = "last_longitude"
        const val LOCATION_ID: String = "location_id"
    }

    fun putDataInt(key: String, value: Int) {
        sharedPreferences.edit()
                .putInt(key, value)
                .apply()
    }

    fun getDataInt(key: String) = sharedPreferences.getInt(key, 0)

    fun putDataBoolean(key: String, value: Boolean) {
        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply()
    }

    fun getDataBoolean(key: String) = sharedPreferences.getBoolean(key, false)

    fun putDataFloat(key: String, value: Float) {
        sharedPreferences.edit()
                .putFloat(key, value)
                .apply()
    }

    fun getDataFloat(key: String) = sharedPreferences.getFloat(key, 0F)

    fun putDataLong(key: String, value: Long) {
        sharedPreferences.edit()
                .putLong(key, value)
                .apply()
    }

    fun getDataLong(key: String) = sharedPreferences.getLong(key, 0L)

    fun putDataString(key: String, value: String) {
        sharedPreferences.edit()
                .putString(key, value)
                .apply()
    }

    fun getDataString(key: String) = sharedPreferences.getString(key, "")

}