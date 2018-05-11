/*
 * Created by YSN Studio on 5/11/18 10:55 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 10:52 PM
 */

package com.ysn.cuacain.di.module.activity.main

import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.views.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    internal fun provideMainPresenter(quoteEndpoints: QuoteEndpoints):
            MainPresenter = MainPresenter(quoteEndpoints = quoteEndpoints)

}