/*
 * Created by YSN Studio on 5/23/18 4:48 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/22/18 5:11 PM
 */

package com.ysn.cuacain.views.ui.activity.home

import android.content.Context
import com.ysn.cuacain.db.entity.daily1dayforecast.EntityDaily1DayForecast
import com.ysn.cuacain.views.base.mvp.BaseView
import com.ysn.cuacain.views.ui.activity.home.adapter.AdapterDaily12HourForecast

interface HomeView : BaseView {

    fun getViewContext(): Context

    fun loadQuoteOfToday(quote: String, author: String)

    fun loadQuoteofTodayFailed(message: String?)

    fun loadDaily1DayForecast(entityDaily1DayForecast: EntityDaily1DayForecast)

    fun loadDaily1DayForecastFailed(message: String?)

    fun loadDaily12HourForecast(adapterDaily12HourForecast: AdapterDaily12HourForecast)

    fun loadDaily12HourForecastFailed(message: String?)


}
