/*
 * Created by YSN Studio on 5/10/18 11:21 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 11:18 PM
 */

package com.ysn.cuacain.di.module.activity.main

import com.ysn.cuacain.api.Endpoints
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.views.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    internal fun provideMainPresenter(endpoints: Endpoints): MainPresenter = MainPresenter(endpoints = endpoints)

}