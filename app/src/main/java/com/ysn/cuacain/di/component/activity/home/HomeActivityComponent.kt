/*
 * Created by YSN Studio on 5/20/18 10:25 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 12:00 AM
 */

package com.ysn.cuacain.di.component.activity.home

import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.module.activity.home.HomeActivityModule
import com.ysn.cuacain.views.ui.activity.home.HomeActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(HomeActivityModule::class)])
interface HomeActivityComponent {

    fun inject(homeActivity: HomeActivity)

}