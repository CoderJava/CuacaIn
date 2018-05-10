/*
 * Created by YSN Studio on 5/10/18 11:06 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 10:39 PM
 */

package com.ysn.cuacain.views.base.mvp

interface Presenter<V: BaseView> {

    fun attachView(view: V)

    fun detachView()

}