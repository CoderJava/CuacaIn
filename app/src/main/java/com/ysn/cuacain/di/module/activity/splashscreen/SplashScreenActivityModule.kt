/*
 * Created by YSN Studio on 5/20/18 11:50 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 10:44 PM
 */

package com.ysn.cuacain.di.module.activity.splashscreen

import com.ysn.cuacain.api.weather.WeatherEndpoints
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.model.sharedpreferences.SharedPreferencesManager
import com.ysn.cuacain.views.ui.activity.splashscreen.SplashScreenPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashScreenActivityModule {

    @ActivityScope
    @Provides
    internal fun provideSplashScreenPresenter(sharedPreferencesManager: SharedPreferencesManager,
                                              weatherEndpoints: WeatherEndpoints): SplashScreenPresenter = SplashScreenPresenter(
            sharedPreferencesManager = sharedPreferencesManager,
            weatherEndpoints = weatherEndpoints
    )

}