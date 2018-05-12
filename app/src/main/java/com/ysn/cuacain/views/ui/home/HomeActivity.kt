/*
 * Created by YSN Studio on 5/12/18 7:40 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/12/18 7:39 AM
 */

package com.ysn.cuacain.views.ui.home

import android.os.Bundle
import com.ysn.cuacain.R
import com.ysn.cuacain.di.component.activity.DaggerHomeActivityComponent
import com.ysn.cuacain.di.module.activity.main.HomeActivityModule
import com.ysn.cuacain.utils.invisible
import com.ysn.cuacain.utils.visible
import com.ysn.cuacain.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        doLoadQuoteOfToday()
    }

    override fun onError() {
        // TODO: do something in here if needed
    }

    override fun onActivityInject() {
        DaggerHomeActivityComponent.builder()
                .appComponent(getAppComponent())
                .homeActivityModule(HomeActivityModule())
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
        text_view_value_quote_of_today_activity_home.text = quote
        text_view_author_quote_of_today_activity_home.text = author
    }

    override fun loadQuoteofTodayFailed(message: String?) {
        hideLoadingQuoteOfToday()
        toast(message!!)
    }

    private fun showLoadingQuoteOfToday() {
        text_view_value_quote_of_today_activity_home.invisible()
        text_view_author_quote_of_today_activity_home.invisible()
        progress_bar_quote_of_today_activity_home.visible()
    }

    private fun hideLoadingQuoteOfToday() {
        text_view_value_quote_of_today_activity_home.visible()
        text_view_author_quote_of_today_activity_home.visible()
        progress_bar_quote_of_today_activity_home.invisible()
    }

}
