/*
 * Created by YSN Studio on 5/20/18 11:53 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 11:53 PM
 */

package com.ysn.cuacain.db

import android.app.Application
import com.ysn.cuacain.db.entity.daily1dayforecast.EntityDaily1DayForecast
import com.ysn.cuacain.views.base.App
import io.objectbox.Box
import javax.inject.Inject

class DbManager @Inject constructor(val application: Application) {

    private var entityDaily1DayForecastBox: Box<EntityDaily1DayForecast> = (application as App).boxStore.boxFor(EntityDaily1DayForecast::class.java)

    /**
     * Put Enttiy Daily 1 Day Forecast Box
     * @param entityDaily1DayForecast - Value entity daily 1 day forecast
     */
    fun putEntityDaily1DayForecastBox(entityDaily1DayForecast: EntityDaily1DayForecast) {
        entityDaily1DayForecastBox.removeAll()
        entityDaily1DayForecastBox.put(entityDaily1DayForecast)
    }

    /**
     * Get all Entity Daily 1 Day Forecast
     */
    fun getAllEntityDaily1DayForecastBox(): List<EntityDaily1DayForecast> = entityDaily1DayForecastBox.all

}