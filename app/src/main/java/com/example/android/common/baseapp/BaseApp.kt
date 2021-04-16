package com.example.android.common.baseapp

import android.app.Application
import android.util.DisplayMetrics
import com.example.android.common.BuildConfig
import com.example.android.common.baseutils.TimberDebugTree
import timber.log.Timber


abstract class BaseApp : Application() {

    abstract fun setBaseUrl()
    abstract fun setDi()

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(TimberDebugTree())
        }
        val displayMetrics = DisplayMetrics()
        setBaseUrl()
        setDi()
       /* startKoin {
            androidContext(this@BaseApp)
            modules(
                listOf(
                    baseCoreModule,
                    baseDbModule,
                    baseViewModules,
                    baseNetworkModule,
                    baseSharePrefModule
                )
            )
        }*/
    }
}