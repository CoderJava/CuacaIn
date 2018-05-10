/*
 * Created by YSN Studio on 5/10/18 11:21 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 11:20 PM
 */

package com.ysn.cuacain.views.ui.main

import android.os.Bundle
import com.ysn.cuacain.R
import com.ysn.cuacain.di.component.activity.DaggerMainActivityComponent
import com.ysn.cuacain.di.module.activity.main.MainActivityModule
import com.ysn.cuacain.views.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onError() {
        // TODO: do something in here if needed
    }

    override fun onActivityInject() {
        DaggerMainActivityComponent.builder()
                .appComponent(getAppComponent())
                .mainActivityModule(MainActivityModule())
                .build()
                .inject(this)
        presenter.attachView(this)
    }

}
