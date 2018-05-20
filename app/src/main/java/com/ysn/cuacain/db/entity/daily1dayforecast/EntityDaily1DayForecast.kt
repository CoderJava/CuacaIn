/*
 * Created by YSN Studio on 5/20/18 11:45 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 9:51 PM
 */

package com.ysn.cuacain.db.entity.daily1dayforecast

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class EntityDaily1DayForecast (
        @Id var id: Long = 0,
        var locationId: String = "",
        var iconWeather: Int = 0,
        var temperatureMinimum: Int = 0,
        var temperatureMaximum: Int = 0,
        var textForecast: String = ""
)