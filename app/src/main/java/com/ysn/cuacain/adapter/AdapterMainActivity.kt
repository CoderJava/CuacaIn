/*
 * Created by YSN Studio on 5/10/18 10:31 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 7:01 PM
 */

package com.ysn.cuacain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ysn.cuacain.R

class AdapterMainActivity constructor(private val listData: List<String>) : RecyclerView.Adapter<AdapterMainActivity.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast_layout, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: do something in here
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView)

}