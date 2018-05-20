/*
 * Created by YSN Studio on 5/20/18 11:54 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 11:38 PM
 */

package com.ysn.cuacain.views.ui.activity.home

import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.api.weather.WeatherEndpoints
import com.ysn.cuacain.db.DbManager
import com.ysn.cuacain.db.entity.daily1dayforecast.EntityDaily1DayForecast
import com.ysn.cuacain.model.sharedpreferences.SharedPreferencesManager
import com.ysn.cuacain.model.weather.currentcondition.ResponseCurrentCondition
import com.ysn.cuacain.model.weather.daily1dayforecast.ResponseDaily1DayForecast
import com.ysn.cuacain.views.base.mvp.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val quoteEndpoints: QuoteEndpoints,
                    private val weatherEndpoints: WeatherEndpoints,
                    private val sharedPreferencesManager: SharedPreferencesManager,
                    private val dbManager: DbManager) : BasePresenter<HomeView>() {

    fun onLoadQuoteOfToday() {
        quoteEndpoints.getQuoteOfToday()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            it.contents.quotes[0].apply {
                                val quote = this.quote
                                val author = this.author
                                view?.loadQuoteOfToday(quote = quote, author = author)
                            }
                        },
                        {
                            it.printStackTrace()
                            view?.loadQuoteofTodayFailed(it.message)
                        },
                        {
                            /* nothing to do in here */
                        }
                )
    }

    fun onLoadDaily1DayForecast() {
        val locationId = sharedPreferencesManager.getDataString(SharedPreferencesManager.LOCATION_ID)
        val observableCurrentCondition = weatherEndpoints.getCurrentConditionWeather(locationId = locationId)
        val observableDaily1DayForecast = weatherEndpoints.getDaily1DayForecast(locationId = locationId)
        Observable
                .zip(observableCurrentCondition, observableDaily1DayForecast, BiFunction<List<ResponseCurrentCondition>, ResponseDaily1DayForecast, EntityDaily1DayForecast> { responseCurrentCondition, responseDaily1DayForecast ->
                    val entityDaily1DayForecast = EntityDaily1DayForecast(
                            locationId = locationId,
                            temperatureMinimum = responseDaily1DayForecast.dailyForecasts[0].temperature.minimum.value!!,
                            temperatureMaximum = responseDaily1DayForecast.dailyForecasts[0].temperature.maximum.value!!,
                            textForecast = responseDaily1DayForecast.headline.text!!,
                            iconWeather = when (responseCurrentCondition[0].isDayTime) {
                                true -> responseDaily1DayForecast.dailyForecasts[0].day.icon!!
                                else -> responseDaily1DayForecast.dailyForecasts[0].night.icon!!
                            }
                    )
                    dbManager.putEntityDaily1DayForecastBox(entityDaily1DayForecast = entityDaily1DayForecast)
                    entityDaily1DayForecast
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.loadDaily1DayForecast(entityDaily1DayForecast = it)
                        },
                        {
                            it.printStackTrace()
                            view?.loadDaily1DayForecastFailed(message = it.message)
                        },
                        {
                            /* nothing to do in here */
                        }
                )
    }

}
