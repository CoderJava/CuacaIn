/*
 * Created by YSN Studio on 5/11/18 11:00 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 9:25 PM
 */

package com.ysn.cuacain.views.ui.main

import com.ysn.cuacain.views.base.mvp.BaseView

interface MainView : BaseView {

    fun loadQuoteOfToday(quote: String, author: String)

    fun loadQuoteofTodayFailed(message: String?)

}
