/*
 * Created by YSN Studio on 5/20/18 1:58 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 1:57 PM
 */

package com.ysn.cuacain.model.weather.daily1dayforecast
import com.google.gson.annotations.SerializedName

data class ResponseDaily1DayForecast(
    @SerializedName("Headline") val headline: Headline,
    @SerializedName("DailyForecasts") val dailyForecasts: List<DailyForecast>
)

data class DailyForecast(
    @SerializedName("Date") val date: String?,
    @SerializedName("EpochDate") val epochDate: Int?,
    @SerializedName("Temperature") val temperature: Temperature,
    @SerializedName("Day") val day: Day,
    @SerializedName("Night") val night: Night,
    @SerializedName("Sources") val sources: List<String?>,
    @SerializedName("MobileLink") val mobileLink: String?,
    @SerializedName("Link") val link: String?
)

data class Temperature(
    @SerializedName("Minimum") val minimum: Minimum,
    @SerializedName("Maximum") val maximum: Maximum
)

data class Maximum(
    @SerializedName("Value") val value: Int?,
    @SerializedName("Unit") val unit: String?,
    @SerializedName("UnitType") val unitType: Int?
)

data class Minimum(
    @SerializedName("Value") val value: Int?,
    @SerializedName("Unit") val unit: String?,
    @SerializedName("UnitType") val unitType: Int?
)

data class Day(
    @SerializedName("Icon") val icon: Int?,
    @SerializedName("IconPhrase") val iconPhrase: String?
)

data class Night(
    @SerializedName("Icon") val icon: Int?,
    @SerializedName("IconPhrase") val iconPhrase: String?
)

data class Headline(
    @SerializedName("EffectiveDate") val effectiveDate: String?,
    @SerializedName("EffectiveEpochDate") val effectiveEpochDate: Int?,
    @SerializedName("Severity") val severity: Int?,
    @SerializedName("Text") val text: String?,
    @SerializedName("Category") val category: String?,
    @SerializedName("EndDate") val endDate: String?,
    @SerializedName("EndEpochDate") val endEpochDate: Int?,
    @SerializedName("MobileLink") val mobileLink: String?,
    @SerializedName("Link") val link: String?
)