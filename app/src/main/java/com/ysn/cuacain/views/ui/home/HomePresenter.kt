/*
 * Created by YSN Studio on 5/12/18 7:40 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/12/18 7:38 AM
 */

package com.ysn.cuacain.views.ui.home

import com.ysn.cuacain.api.quote.QuoteEndpoints
import com.ysn.cuacain.views.base.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val quoteEndpoints: QuoteEndpoints) : BasePresenter<HomeView>() {

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

}