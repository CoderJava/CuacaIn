/*
 * Created by YSN Studio on 5/11/18 10:54 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 10:52 PM
 */

package com.ysn.cuacain.di.module

import com.ysn.cuacain.api.quote.QuoteEndpoints
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class QuoteApiModule {

    @Provides
    @Singleton
    fun provideEndpoints(@Named("quote") retrofit: Retrofit): QuoteEndpoints = retrofit.create(QuoteEndpoints::class.java)

}