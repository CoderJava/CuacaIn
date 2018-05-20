/*
 * Created by YSN Studio on 5/20/18 11:50 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 10:46 PM
 */

package com.ysn.cuacain.di.module.activity.home

import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.api.weather.WeatherEndpoints
import com.ysn.cuacain.db.DbManager
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.model.sharedpreferences.SharedPreferencesManager
import com.ysn.cuacain.views.ui.activity.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    @ActivityScope
    internal fun provideHomePresenter(quoteEndpoints: QuoteEndpoints,
                                      weatherEndpoints: WeatherEndpoints,
                                      sharedPreferencesManager: SharedPreferencesManager,
                                      dbManager: DbManager): HomePresenter = HomePresenter(
            quoteEndpoints = quoteEndpoints,
            weatherEndpoints = weatherEndpoints,
            sharedPreferencesManager = sharedPreferencesManager,
            dbManager = dbManager
    )

}