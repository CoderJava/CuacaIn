/*
 * Created by YSN Studio on 5/10/18 11:09 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 10:49 PM
 */

package com.ysn.cuacain.di.module

import android.app.Application
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(val application: Application) {

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    @Singleton
    fun provideResource() = application.resources

}