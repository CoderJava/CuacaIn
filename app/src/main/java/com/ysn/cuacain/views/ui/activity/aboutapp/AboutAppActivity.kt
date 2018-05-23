/*
 * Created by YSN Studio on 5/23/18 8:00 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/23/18 7:59 AM
 */

package com.ysn.cuacain.views.ui.activity.aboutapp

import android.os.Bundle
import com.ysn.cuacain.BuildConfig
import com.ysn.cuacain.R
import com.ysn.cuacain.di.component.activity.aboutapp.DaggerAboutAppActivityComponent
import com.ysn.cuacain.di.module.activity.aboutapp.AboutAppActivityModule
import com.ysn.cuacain.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about_app.*
import javax.inject.Inject

class AboutAppActivity : BaseActivity(), AboutAppView {

    @Inject
    lateinit var presenter: AboutAppPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)
        doLoadData()
    }

    private fun doLoadData() {
        val versionNameApp = BuildConfig.VERSION_NAME
        text_view_app_version_name_activity_about_app.text = versionNameApp
    }

    override fun onError() {
        // TODO: do something in here if needed
    }

    override fun onActivityInject() {
        DaggerAboutAppActivityComponent.builder()
                .appComponent(getAppComponent())
                .aboutAppActivityModule(AboutAppActivityModule())
                .build()
                .inject(this)
        presenter.attachView(this)
    }

}
