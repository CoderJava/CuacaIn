/*
 * Created by YSN Studio on 5/29/18 2:15 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/29/18 2:12 PM
 */

package com.ysn.cuacain.views.ui.activity.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ysn.cuacain.R
import com.ysn.cuacain.model.weather.daily12hourforecast.ResponseDaily12HourForecast
import com.ysn.cuacain.utils.setIconWeather
import org.jetbrains.anko.find
import java.text.SimpleDateFormat
import java.util.*

class AdapterDaily12HourForecast(private val context: Context,
                                 private val listDaily12HourForecast: MutableList<ResponseDaily12HourForecast>) : RecyclerView.Adapter<AdapterDaily12HourForecast.ViewHolderItemDaily12HourForecast>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemDaily12HourForecast {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_12_hour_forecast_layout, parent, false)
        return ViewHolderItemDaily12HourForecast(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolderItemDaily12HourForecast, position: Int) {
        val responseDaily12HourForecast = listDaily12HourForecast[position]
        val formatTimeDaily = SimpleDateFormat("HH:mm", Locale.US)
                .format(stringISOToDate(responseDaily12HourForecast.dateTime))
        holder.textViewTimeItemDaily12HourForecast.text = formatTimeDaily
        if (formatTimeDaily == "00:00" && responseDaily12HourForecast.isDaylight!!) {
            holder.textViewTimeItemDaily12HourForecast.text = "12:00"
        } else if (formatTimeDaily == "00:00" && !responseDaily12HourForecast.isDaylight!!) {
            holder.textViewTimeItemDaily12HourForecast.text = "00:00"
        }
        holder.textViewWeatherTemperatureItemDaily12HourForecast.text = responseDaily12HourForecast.temperature.value.toString()
        holder.imageViewWeatherItemDaily12HourForecast.setIconWeather(idIconWeather = responseDaily12HourForecast.weatherIcon!!, context = context)
    }

    override fun getItemCount(): Int = listDaily12HourForecast.size

    inner class ViewHolderItemDaily12HourForecast constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewTimeItemDaily12HourForecast = itemView.find<TextView>(R.id.text_view_time_item_12_hour_forecast_layout)
        val imageViewWeatherItemDaily12HourForecast = itemView.find<ImageView>(R.id.image_view_icon_weather_item_12_hour_forecast_layout)
        val textViewWeatherTemperatureItemDaily12HourForecast = itemView.find<TextView>(R.id.text_view_weather_temperature_item_12_hour_forecast_layout)

    }

    private fun stringISOToDate(dateTimeISO: String?): Date? {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZZ", Locale.US)
        return formatter.parse(dateTimeISO)
    }

}
