/*
 * Created by YSN Studio on 5/12/18 7:42 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/12/18 7:38 AM
 */

package com.ysn.cuacain.di.component.activity

import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.module.activity.main.HomeActivityModule
import com.ysn.cuacain.views.ui.home.HomeActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(HomeActivityModule::class)])
interface HomeActivityComponent {

    fun inject(homeActivity: HomeActivity)

}