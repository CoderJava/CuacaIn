/*
 * Created by YSN Studio on 5/20/18 1:30 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 1:29 PM
 */

package com.ysn.cuacain.views.ui.activity.splashscreen

import android.location.Location
import com.ysn.cuacain.model.sharedpreferences.SharedPreferencesManager
import com.ysn.cuacain.views.base.mvp.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashScreenPresenter (private val sharedPreferencesManager: SharedPreferencesManager) : BasePresenter<SplashScreenView>() {

    fun onSaveLastLocation(location: Location?) {
        Observable
                .create<Boolean> {
                    location?.let {
                        sharedPreferencesManager.putDataFloat(SharedPreferencesManager.LAST_LATITUDE, it.latitude.toFloat())
                        sharedPreferencesManager.putDataFloat(SharedPreferencesManager.LAST_LONGITUDE, it.longitude.toFloat())
                    }
                    it.onNext(true)
                    it.onComplete()
                }
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.saveLastLocation()
                        },
                        {
                            it.printStackTrace()
                            view?.saveLastLocationFailed(message = it.message)
                        },
                        {
                            /* nothing to do in here */
                        }
                )
    }

}
