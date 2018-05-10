/*
 * Created by YSN Studio on 5/10/18 11:10 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 11:04 PM
 */

package com.ysn.cuacain.views.base

import android.app.Application
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.component.DaggerAppComponent
import com.ysn.cuacain.di.module.AppModule

class App : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}