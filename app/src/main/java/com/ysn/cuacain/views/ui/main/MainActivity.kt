/*
 * Created by YSN Studio on 5/11/18 11:00 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 9:25 PM
 */

package com.ysn.cuacain.views.ui.main

import android.os.Bundle
import com.ysn.cuacain.R
import com.ysn.cuacain.di.component.activity.DaggerMainActivityComponent
import com.ysn.cuacain.di.module.activity.main.MainActivityModule
import com.ysn.cuacain.utils.invisible
import com.ysn.cuacain.utils.visible
import com.ysn.cuacain.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doLoadQuoteOfToday()
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

    private fun doLoadQuoteOfToday() {
        showLoadingQuoteOfToday()
        presenter.onLoadQuoteOfToday()
    }

    override fun loadQuoteOfToday(quote: String, author: String) {
        hideLoadingQuoteOfToday()
        text_view_value_quote_of_today_activity_main.text = quote
        text_view_author_quote_of_today_activity_main.text = author
    }

    override fun loadQuoteofTodayFailed(message: String?) {
        hideLoadingQuoteOfToday()
        toast(message!!)
    }

    private fun showLoadingQuoteOfToday() {
        text_view_value_quote_of_today_activity_main.invisible()
        text_view_author_quote_of_today_activity_main.invisible()
        progress_bar_quote_of_today_activity_main.visible()
    }

    private fun hideLoadingQuoteOfToday() {
        text_view_value_quote_of_today_activity_main.visible()
        text_view_author_quote_of_today_activity_main.visible()
        progress_bar_quote_of_today_activity_main.invisible()
    }

}
