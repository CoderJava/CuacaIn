/*
 * Created by YSN Studio on 5/20/18 11:51 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 7:31 PM
 */

package com.ysn.cuacain.views.ui.activity.splashscreen

import android.location.Location
import com.ysn.cuacain.views.base.mvp.BaseView

interface SplashScreenView : BaseView {

    fun saveLastLocation(location: Location?)

    fun saveLastLocationFailed(message: String?)

    fun getLocationWeather(locationId: String?)

    fun getLocationWeatherFailed(message: String?)

}
