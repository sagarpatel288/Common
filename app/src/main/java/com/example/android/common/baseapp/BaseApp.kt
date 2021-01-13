package com.example.android.common.baseapp

import android.app.Application
import android.util.DisplayMetrics




abstract class BaseApp : Application() {

    abstract fun setBaseUrl()
    abstract fun setDi()

    override fun onCreate() {
        super.onCreate()
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