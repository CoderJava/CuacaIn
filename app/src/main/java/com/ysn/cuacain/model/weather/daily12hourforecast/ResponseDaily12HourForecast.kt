/*
 * Created by YSN Studio on 5/20/18 1:59 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 1:56 PM
 */

package com.ysn.cuacain.model.weather.daily12hourforecast

import com.google.gson.annotations.SerializedName

data class ResponseDaily12HourForecast(
        @SerializedName("DateTime") val dateTime: String?,
        @SerializedName("EpochDateTime") val epochDateTime: Int?,
        @SerializedName("WeatherIcon") val weatherIcon: Int?,
        @SerializedName("IconPhrase") val iconPhrase: String?,
        @SerializedName("IsDaylight") val isDaylight: Boolean?,
        @SerializedName("Temperature") val temperature: Temperature,
        @SerializedName("PrecipitationProbability") val precipitationProbability: Int?,
        @SerializedName("MobileLink") val mobileLink: String?,
        @SerializedName("Link") val link: String?
)

data class Temperature(
        @SerializedName("Value") val value: Int?,
        @SerializedName("Unit") val unit: String?,
        @SerializedName("UnitType") val unitType: Int?
)