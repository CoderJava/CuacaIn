/*
 * Created by YSN Studio on 5/11/18 10:44 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 10:39 PM
 */

package com.ysn.cuacain.di.component

import android.app.Application
import android.content.SharedPreferences
import com.google.gson.Gson
import com.ysn.cuacain.api.QuoteEndpoints
import com.ysn.cuacain.di.module.*
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RetrofitModule::class), (QuoteApiModule::class), (OkHttpModule::class), (SharedPreferencesModule::class)])
interface AppComponent {

    fun application(): Application

    fun gson(): Gson

    @Named("quote")
    fun retrofit(): Retrofit

    fun quoteEndpoints(): QuoteEndpoints

    fun cache(): Cache

    fun client(): OkHttpClient

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun sharedPreferences(): SharedPreferences

}