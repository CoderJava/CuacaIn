/*
 * Created by YSN Studio on 5/12/18 7:41 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/12/18 7:38 AM
 */

package com.ysn.cuacain.views.ui.home

import com.ysn.cuacain.views.base.mvp.BaseView

interface HomeView : BaseView {

    fun loadQuoteOfToday(quote: String, author: String)

    fun loadQuoteofTodayFailed(message: String?)

}
