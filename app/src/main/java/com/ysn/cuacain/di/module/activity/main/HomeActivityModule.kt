/*
 * Created by YSN Studio on 5/12/18 7:42 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/12/18 7:36 AM
 */

package com.ysn.cuacain.di.module.activity.main

import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.views.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    @ActivityScope
    internal fun provideHomePresenter(quoteEndpoints: QuoteEndpoints):
            HomePresenter = HomePresenter(quoteEndpoints = quoteEndpoints)

}