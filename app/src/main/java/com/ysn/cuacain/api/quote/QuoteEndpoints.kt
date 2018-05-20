/*
 * Created by YSN Studio on 5/20/18 2:00 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 1:50 PM
 */

package com.ysn.cuacain.api.quote

import com.ysn.cuacain.model.quote.quoteoftoday.ResponseQuoteOfToday
import io.reactivex.Observable
import retrofit2.http.GET

interface QuoteEndpoints {

    @GET("qod")
    fun getQuoteOfToday(): Observable<ResponseQuoteOfToday>

}