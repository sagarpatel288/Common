package com.example.android.common.baseapp

import android.app.Application
import com.example.android.common.basedi.baseNetworkmodules.baseNetworkModule
import com.example.android.common.basedi.baseSharedPrefsModule.baseSharePrefModule
import com.example.android.common.basedi.basecoremodule.baseCoreModule
import com.example.android.common.basedi.basedbmodules.baseDbModule
import com.example.android.common.basedi.baseviewmodules.baseViewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(listOf(baseCoreModule, baseDbModule, baseViewModules, baseNetworkModule, baseSharePrefModule))
        }
    }
}