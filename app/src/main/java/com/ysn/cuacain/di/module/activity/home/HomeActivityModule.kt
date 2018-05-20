/*
 * Created by YSN Studio on 5/20/18 10:25 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 12:00 AM
 */

package com.ysn.cuacain.di.module.activity.home

import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.views.ui.activity.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    @ActivityScope
    internal fun provideHomePresenter(quoteEndpoints: QuoteEndpoints):
            HomePresenter = HomePresenter(quoteEndpoints = quoteEndpoints)

}