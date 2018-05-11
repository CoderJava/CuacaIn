/*
 * Created by YSN Studio on 5/11/18 10:53 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 10:53 PM
 */

package com.ysn.cuacain.api.quote

import com.ysn.cuacain.model.quote.ResponseQuoteOfToday
import io.reactivex.Observable
import retrofit2.http.GET

interface QuoteEndpoints {

    @GET("qod")
    fun getQuoteOfToday(): Observable<ResponseQuoteOfToday>

}