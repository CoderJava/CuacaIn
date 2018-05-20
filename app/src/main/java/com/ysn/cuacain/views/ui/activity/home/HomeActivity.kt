/*
 * Created by YSN Studio on 5/20/18 11:54 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 11:40 PM
 */

package com.ysn.cuacain.views.ui.activity.home

import android.os.Bundle
import com.ysn.cuacain.R
import com.ysn.cuacain.db.entity.daily1dayforecast.EntityDaily1DayForecast
import com.ysn.cuacain.di.component.activity.home.DaggerHomeActivityComponent
import com.ysn.cuacain.di.module.activity.home.HomeActivityModule
import com.ysn.cuacain.utils.gone
import com.ysn.cuacain.utils.invisible
import com.ysn.cuacain.utils.setIconWeather
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
        doLoadDaily1DayForecast()
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

    private fun doLoadDaily1DayForecast() {
        showLoadingDaily1DayForecast()
        presenter.onLoadDaily1DayForecast()
    }

    private fun showLoadingDaily1DayForecast() {
        linear_layout_container_content_label_headline_activity_home.invisible()
        linear_layout_container_content_headline_activity_home.gone()
        relative_layout_container_loading_headline_activity_home.visible()
    }

    private fun hideLoadingDaily1DayForecast() {
        linear_layout_container_content_label_headline_activity_home.visible()
        linear_layout_container_content_headline_activity_home.visible()
        relative_layout_container_loading_headline_activity_home.gone()
    }

    override fun loadDaily1DayForecast(entityDaily1DayForecast: EntityDaily1DayForecast) {
        hideLoadingDaily1DayForecast()
        entityDaily1DayForecast.let {
            text_view_weather_temperature_minimum_content_headline_activity_home.text = it.temperatureMinimum.toString()
            text_view_weather_temperature_maximum_content_headline_activity_home.text = it.temperatureMaximum.toString()
            text_view_weather_condition_content_headline_activity_home.text = it.textForecast
            image_view_icon_weather_content_headline_activity_home.setIconWeather(context = this, idIconWeather = it.iconWeather)
        }
    }

    override fun loadDaily1DayForecastFailed(message: String?) {
        hideLoadingDaily1DayForecast()
        toast(message!!)
    }
}
