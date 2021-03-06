/*
 * Created by YSN Studio on 5/20/18 11:49 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 10:44 PM
 */

package com.ysn.cuacain.di.component

import android.app.Application
import android.content.SharedPreferences
import com.google.gson.Gson
import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.api.weather.WeatherEndpoints
import com.ysn.cuacain.di.module.*
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RetrofitModule::class), (QuoteApiModule::class), (WeatherApiModule::class), (OkHttpModule::class), (SharedPreferencesModule::class)])
interface AppComponent {

    fun application(): Application

    fun gson(): Gson

    @Named("quote")
    fun retrofitQuote(): Retrofit

    @Named("weather")
    fun retrofitWeather(): Retrofit

    fun quoteEndpoints(): QuoteEndpoints

    fun weatherEndpoints(): WeatherEndpoints

    fun cache(): Cache

    fun client(): OkHttpClient

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun sharedPreferences(): SharedPreferences

}