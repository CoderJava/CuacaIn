/*
 * Created by YSN Studio on 5/10/18 11:21 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 11:19 PM
 */

package com.ysn.cuacain.di.component.activity

import com.ysn.cuacain.di.ActivityScope
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.module.activity.main.MainActivityModule
import com.ysn.cuacain.views.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [(AppComponent::class)], modules = [(MainActivityModule::class)])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}