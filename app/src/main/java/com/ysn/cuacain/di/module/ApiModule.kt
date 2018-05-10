/*
 * Created by YSN Studio on 5/10/18 11:08 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 10:47 PM
 */

package com.ysn.cuacain.di.module

import com.ysn.cuacain.api.Endpoints
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideEndpoints(retrofit: Retrofit): Endpoints = retrofit.create(Endpoints::class.java)

}