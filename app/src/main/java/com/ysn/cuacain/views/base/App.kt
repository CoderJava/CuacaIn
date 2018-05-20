/*
 * Created by YSN Studio on 5/20/18 11:47 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 10:28 PM
 */

package com.ysn.cuacain.views.base

import android.app.Application
import com.ysn.cuacain.db.entity.daily1dayforecast.MyObjectBox
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.di.component.DaggerAppComponent
import com.ysn.cuacain.di.module.AppModule
import io.objectbox.BoxStore

class App : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    lateinit var boxStore: BoxStore
        private set

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initObjectBox()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    private fun initObjectBox() {
        boxStore = MyObjectBox.builder()
                .androidContext(this)
                .build()
    }

}