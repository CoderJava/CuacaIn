/*
 * Created by YSN Studio on 5/23/18 4:46 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/23/18 4:43 AM
 */

package com.ysn.cuacain.model.weather.currentcondition

import com.google.gson.annotations.SerializedName

data class ResponseCurrentCondition(
        @SerializedName("LocalObservationDateTime") val localObservationDateTime: String?,
        @SerializedName("EpochTime") val epochTime: Int?,
        @SerializedName("WeatherText") val weatherText: String?,
        @SerializedName("WeatherIcon") val weatherIcon: Int?,
        @SerializedName("IsDayTime") val isDayTime: Boolean?,
        @SerializedName("Temperature") val temperature: Temperature,
        @SerializedName("MobileLink") val mobileLink: String?,
        @SerializedName("Link") val link: String?
)

data class Temperature(
        @SerializedName("Metric") val metric: Metric,
        @SerializedName("Imperial") val imperial: Imperial
)

data class Metric(
        @SerializedName("Value") val value: Double?,
        @SerializedName("Unit") val unit: String?,
        @SerializedName("UnitType") val unitType: Int?
)

data class Imperial(
        @SerializedName("Value") val value: Int?,
        @SerializedName("Unit") val unit: String?,
        @SerializedName("UnitType") val unitType: Int?
)