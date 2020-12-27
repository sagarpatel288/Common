package com.example.android.common.baseapp

import android.app.Application

abstract class BaseApp : Application() {

    abstract fun setBaseUrl()
    abstract fun setDi()

    override fun onCreate() {
        super.onCreate()
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