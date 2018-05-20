/*
 * Created by YSN Studio on 5/20/18 11:48 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 11:38 PM
 */

package com.ysn.cuacain.api.weather

import com.ysn.cuacain.BuildConfig
import com.ysn.cuacain.model.weather.currentcondition.ResponseCurrentCondition
import com.ysn.cuacain.model.weather.daily12hourforecast.ResponseDaily12HourForecast
import com.ysn.cuacain.model.weather.daily1dayforecast.ResponseDaily1DayForecast
import com.ysn.cuacain.model.weather.locationweather.ResponseLocationWeather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherEndpoints {

    @GET("locations/v1/cities/geoposition/search")
    fun getLocationWeather(@Query("apikey") apiKey: String = BuildConfig.API_KEY_ACCU_WEATHER,
                           @Query("q") q: String = ""): Observable<ResponseLocationWeather>

    @GET("currentconditions/v1/{locationId}")
    fun getCurrentConditionWeather(@Path("locationId") locationId: String = "",
                                   @Query("apikey") apiKey: String = BuildConfig.API_KEY_ACCU_WEATHER)
            : Observable<List<ResponseCurrentCondition>>

    @GET("forecasts/v1/daily/1day/{locationId}")
    fun getDaily1DayForecast(@Path("locationId") locationId: String = "",
                             @Query("apikey") apiKey: String = BuildConfig.API_KEY_ACCU_WEATHER)
            : Observable<ResponseDaily1DayForecast>

    @GET("forecasts/v1/hourly/12hour/{locationId}")
    fun getDaily12HourForecast(@Path("locationId") locationId: String = "",
                               @Query("apikey") apiKey: String = BuildConfig.API_KEY_ACCU_WEATHER)
            : Observable<ResponseDaily12HourForecast>

}