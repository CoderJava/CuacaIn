/*
 * Created by YSN Studio on 5/10/18 11:10 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 11:03 PM
 */

package com.ysn.cuacain.di.component

import android.app.Application
import android.content.SharedPreferences
import com.google.gson.Gson
import com.ysn.cuacain.api.Endpoints
import com.ysn.cuacain.di.module.*
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RetrofitModule::class), (ApiModule::class), (OkHttpModule::class), (SharedPreferencesModule::class)])
interface AppComponent {

    fun application(): Application

    fun gson(): Gson

    fun retrofit(): Retrofit

    fun endpoints(): Endpoints

    fun cache(): Cache

    fun client(): OkHttpClient

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun sharedPreferences(): SharedPreferences

}