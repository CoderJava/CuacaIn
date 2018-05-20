/*
 * Created by YSN Studio on 5/20/18 10:25 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 12:00 AM
 */

package com.ysn.cuacain.di.component.activity.splashscreen

import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.module.activity.splashscreen.SplashScreenActivityModule
import com.ysn.cuacain.views.ui.activity.splashscreen.SplashScreenActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(SplashScreenActivityModule::class)])
interface SplashScreenActivityComponent {

    fun inject(splashScreenActivity: SplashScreenActivity)

}