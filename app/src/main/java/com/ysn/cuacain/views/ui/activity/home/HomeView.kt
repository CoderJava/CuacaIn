/*
 * Created by YSN Studio on 5/20/18 11:54 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 11:00 PM
 */

package com.ysn.cuacain.views.ui.activity.home

import com.ysn.cuacain.db.entity.daily1dayforecast.EntityDaily1DayForecast
import com.ysn.cuacain.views.base.mvp.BaseView

interface HomeView : BaseView {

    fun loadQuoteOfToday(quote: String, author: String)

    fun loadQuoteofTodayFailed(message: String?)

    fun loadDaily1DayForecast(entityDaily1DayForecast: EntityDaily1DayForecast)

    fun loadDaily1DayForecastFailed(message: String?)


}
