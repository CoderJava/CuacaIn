/*
 * Created by YSN Studio on 5/11/18 9:10 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 9:10 PM
 */

package com.ysn.cuacain.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(client: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

}