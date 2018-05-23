/*
 * Created by YSN Studio on 5/23/18 8:00 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/23/18 7:57 AM
 */

package com.ysn.cuacain.di.component.activity.aboutapp

import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.module.activity.aboutapp.AboutAppActivityModule
import com.ysn.cuacain.views.ui.activity.aboutapp.AboutAppActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(AboutAppActivityModule::class)])
interface AboutAppActivityComponent {

    fun inject(aboutAppActivity: AboutAppActivity)

}