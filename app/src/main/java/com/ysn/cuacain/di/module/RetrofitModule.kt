/*
 * Created by YSN Studio on 5/11/18 10:43 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/11/18 10:36 PM
 */

package com.ysn.cuacain.di.module

import com.ysn.cuacain.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Named("quote")
    @Singleton
    fun provideRetrofitClient(client: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_QUOTE_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

}