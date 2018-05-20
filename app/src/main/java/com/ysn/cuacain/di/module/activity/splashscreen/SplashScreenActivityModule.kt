/*
 * Created by YSN Studio on 5/20/18 10:25 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 12:00 AM
 */

package com.ysn.cuacain.di.module.activity.splashscreen

import android.app.Application
import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.views.ui.activity.splashscreen.SplashScreenPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashScreenActivityModule {

    @ActivityScope
    @Provides
    internal fun provideSplashScreenPresenter(context: Application): SplashScreenPresenter = SplashScreenPresenter(context = context)

}