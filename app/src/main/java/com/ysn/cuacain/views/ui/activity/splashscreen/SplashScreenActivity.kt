/*
 * Created by YSN Studio on 5/20/18 1:30 PM
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 5/20/18 1:27 PM
 */

package com.ysn.cuacain.views.ui.activity.splashscreen

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
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
import com.ysn.cuacain.views.ui.activity.home.HomeActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(), SplashScreenView, AnkoLogger,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    @Inject
    lateinit var presenter: SplashScreenPresenter

    private lateinit var mGoogleApiClient: GoogleApiClient

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

        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> run {
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

                            info { "onPermissionChecked" }
                            if (this.areAllPermissionsGranted()) {
                                googleApiClientConnect()
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
    }

    private fun googleApiClientConnect() {
        info { "googleApiClientConnect" }
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()
        mGoogleApiClient.connect()
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(bundle: Bundle?) {
        LocationServices.getFusedLocationProviderClient(this).lastLocation.addOnSuccessListener {
            presenter.onSaveLastLocation(location = it)
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        /* nothing to do in here */
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        /* nothing to do in here */
    }

    override fun saveLastLocation() {
        startActivity(intentFor<HomeActivity>().clearTask().newTask())
    }

    override fun saveLastLocationFailed(message: String?) {
        snackbar(find(android.R.id.content), message ?: getString(R.string.error_occured_to_get_your_location))
                .addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                        super.onDismissed(transientBottomBar, event)
                        finish()
                    }
                })
                .show()
    }

}
