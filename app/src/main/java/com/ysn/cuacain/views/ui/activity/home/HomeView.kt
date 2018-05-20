/*
 * Created by YSN Studio on 5/20/18 10:25 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 12:00 AM
 */

package com.ysn.cuacain.views.ui.activity.home

import com.ysn.cuacain.views.base.mvp.BaseView

interface HomeView : BaseView {

    fun loadQuoteOfToday(quote: String, author: String)

    fun loadQuoteofTodayFailed(message: String?)

}
