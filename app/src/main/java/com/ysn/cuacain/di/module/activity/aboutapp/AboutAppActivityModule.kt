/*
 * Created by YSN Studio on 5/23/18 8:00 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/23/18 7:56 AM
 */

package com.ysn.cuacain.di.module.activity.aboutapp

import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.views.ui.activity.aboutapp.AboutAppPresenter
import dagger.Module
import dagger.Provides

@Module
class AboutAppActivityModule {

    @ActivityScope
    @Provides
    internal fun provideAboutAppPresenter() : AboutAppPresenter = AboutAppPresenter()

}