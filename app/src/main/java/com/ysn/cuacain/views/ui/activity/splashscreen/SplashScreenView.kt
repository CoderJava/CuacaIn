/*
 * Created by YSN Studio on 5/20/18 1:30 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 1:27 PM
 */

package com.ysn.cuacain.views.ui.activity.splashscreen

import com.ysn.cuacain.views.base.mvp.BaseView

interface SplashScreenView : BaseView {

    fun saveLastLocation()

    fun saveLastLocationFailed(message: String?)

}
