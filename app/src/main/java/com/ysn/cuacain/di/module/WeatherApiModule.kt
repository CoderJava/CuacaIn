/*
 * Created by YSN Studio on 5/11/18 10:55 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 10:52 PM
 */

package com.ysn.cuacain.di.module

import com.ysn.cuacain.api.weather.WeatherEndpoints
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class WeatherApiModule {

    @Provides
    @Singleton
    fun provideEndpoints(@Named("weather") retrofit: Retrofit): WeatherEndpoints = retrofit.create(WeatherEndpoints::class.java)

}