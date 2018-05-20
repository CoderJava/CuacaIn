/*
 * Created by YSN Studio on 5/20/18 10:25 AM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 10:22 AM
 */

package com.ysn.cuacain.views.ui.activity.splashscreen

import android.Manifest
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.CompositeMultiplePermissionsListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.multi.SnackbarOnAnyDeniedMultiplePermissionsListener
import com.ysn.cuacain.R
import com.ysn.cuacain.di.component.activity.splashscreen.DaggerSplashScreenActivityComponent
import com.ysn.cuacain.di.module.activity.splashscreen.SplashScreenActivityModule
import com.ysn.cuacain.views.base.BaseActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(), SplashScreenView, AnkoLogger {

    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        checkRuntimePermissions()
    }

    override fun onError() {
        // TODO: do something in here if needed
    }

    override fun onActivityInject() {
        DaggerSplashScreenActivityComponent.builder()
                .appComponent(getAppComponent())
                .splashScreenActivityModule(SplashScreenActivityModule())
                .build()
                .inject(this)
        presenter.attachView(this)
    }

    private fun checkRuntimePermissions() {
        val permissions = mutableListOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        )
        val multiplePermissionListener = object : MultiplePermissionsListener {
            override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                report?.apply {
                    this.grantedPermissionResponses.forEach {
                        /* TODO: do something in here if you need to show permission granted */
                    }

                    this.deniedPermissionResponses.forEach {
                        /* TODO: do something in here if you need to show permission denied */
                    }
                }
            }

            override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {
                /* TODO: do something in here if you need to show description if your permission is already denied */
                /*AlertDialog.Builder(this@SplashScreenActivity)
                        .setTitle("We need this permission")
                        .setMessage("This permission is needed for doing some fancy stuff so please, allow it!")
                        .setNegativeButton("Cancel", { dialogInterface, _ ->
                            dialogInterface.dismiss()
                            token?.continuePermissionRequest()
                        })
                        .setPositiveButton("OK", { dialogInterface, _ ->
                            dialogInterface.dismiss()
                            token?.continuePermissionRequest()
                        })
                        .setOnDismissListener {
                            token?.cancelPermissionRequest()
                        }
                        .show()*/
            }
        }
        val snackbarOnAnyDeniedMultiplePermissionsListener = SnackbarOnAnyDeniedMultiplePermissionsListener.Builder
                .with(find(android.R.id.content), getString(R.string.all_permissions_denied))
                .withOpenSettingsButton(getString(R.string.settings).toUpperCase())
                .withCallback(object : Snackbar.Callback() {
                    override fun onShown(sb: Snackbar?) {
                        super.onShown(sb)
                    }

                    override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                        finish()
                        super.onDismissed(transientBottomBar, event)
                    }
                })
                .build()
        val allPermissionsListener = CompositeMultiplePermissionsListener(multiplePermissionListener,
                snackbarOnAnyDeniedMultiplePermissionsListener)
        Dexter.withActivity(this)
                .withPermissions(permissions)
                .withListener(allPermissionsListener)
                .check()
    }

}
