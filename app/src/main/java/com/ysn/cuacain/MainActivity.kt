/*
 * Created by YSN Studio on 5/10/18 10:31 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 7:03 PM
 */

package com.ysn.cuacain

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.ysn.cuacain.adapter.AdapterMainActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listData = mutableListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        val adapterMainActivity = AdapterMainActivity(listData)
        recycler_view_forecast_activity_main.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        recycler_view_forecast_activity_main.adapter = adapterMainActivity
    }
}
