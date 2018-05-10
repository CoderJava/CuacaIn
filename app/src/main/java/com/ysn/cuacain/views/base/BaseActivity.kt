/*
 * Created by YSN Studio on 5/10/18 11:10 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 11:03 PM
 */

package com.ysn.cuacain.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ysn.cuacain.di.component.AppComponent
import com.ysn.cuacain.views.base.mvp.BasePresenter
import com.ysn.cuacain.views.base.mvp.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var presenter: BasePresenter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityInject()
    }

    protected abstract fun onActivityInject()

    fun getAppComponent(): AppComponent = App.appComponent

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }

    override fun onStart() {
        super.onStart()
        // TODO: do something in here if needed
    }

    override fun onStop() {
        super.onStop()
        // TODO: do something in here if needed
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        presenter = null
    }

}