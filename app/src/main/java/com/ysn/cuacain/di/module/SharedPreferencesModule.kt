/*
 * Created by YSN Studio on 5/10/18 11:09 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 10:59 PM
 */

package com.ysn.cuacain.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences = application.getSharedPreferences("PREF_APP", Context.MODE_PRIVATE)

}