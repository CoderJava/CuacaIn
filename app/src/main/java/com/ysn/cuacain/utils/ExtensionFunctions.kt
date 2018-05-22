/*
 * Created by YSN Studio on 5/23/18 4:45 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/23/18 4:45 AM
 */

package com.ysn.cuacain.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import com.ysn.cuacain.R

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.setIconWeather(idIconWeather: Int, context: Context) {
    var imageDrawable : Drawable? = null
    when (idIconWeather) {
        1 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_01_s)
        2 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_02_s)
        3 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_03_s)
        4 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_04_s)
        5 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_05_s)
        6 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_06_s)
        7 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_07_s)
        8 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_08_s)
        11 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_11_s)
        12 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_12_s)
        13 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_13_s)
        14 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_14_s)
        15 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_15_s)
        16 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_16_s)
        17 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_17_s)
        18 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_18_s)
        19 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_19_s)
        20 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_20_s)
        21 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_21_s)
        22 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_22_s)
        23 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_23_s)
        24 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_24_s)
        25 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_25_s)
        26 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_26_s)
        29 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_29_s)
        30 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_30_s)
        31 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_31_s)
        32 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_32_s)
        33 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_33_s)
        34 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_34_s)
        35 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_35_s)
        36 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_36_s)
        37 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_37_s)
        38 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_38_s)
        39 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_39_s)
        40 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_40_s)
        41 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_41_s)
        42 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_42_s)
        43 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_43_s)
        44 -> imageDrawable = ContextCompat.getDrawable(context, R.drawable.img_44_s)
    }
    setImageDrawable(imageDrawable)
}