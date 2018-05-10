/*
 * Created by YSN Studio on 5/10/18 11:07 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/10/18 10:41 PM
 */

package com.ysn.cuacain.views.base.mvp

import java.lang.ref.WeakReference

open class BasePresenter<V : BaseView> : Presenter<V> {

    private var weakReference: WeakReference<V>? = null

    override fun attachView(view: V) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
            view.setPresenter(this)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }

    val view: V?
        get() = weakReference?.get()

    private val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null

}