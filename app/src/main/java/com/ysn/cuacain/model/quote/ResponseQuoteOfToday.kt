/*
 * Created by YSN Studio on 5/11/18 10:57 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 9:13 PM
 */

package com.ysn.cuacain.model.quote

import com.google.gson.annotations.SerializedName

data class ResponseQuoteOfToday(
        @SerializedName("success") val success: Success,
        @SerializedName("contents") val contents: Contents
)

data class Contents(
        @SerializedName("quotes") val quotes: List<Quote>,
        @SerializedName("copyright") val copyright: String
)

data class Quote(
        @SerializedName("quote") val quote: String,
        @SerializedName("author") val author: String,
        @SerializedName("length") val length: String,
        @SerializedName("tags") val tags: List<String>,
        @SerializedName("category") val category: String,
        @SerializedName("title") val title: String,
        @SerializedName("date") val date: String,
        @SerializedName("id") val id: Any
)

data class Success(
        @SerializedName("total") val total: Int
)

