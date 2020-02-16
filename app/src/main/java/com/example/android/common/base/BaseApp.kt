package com.example.android.common.base

import android.app.Application
import com.example.android.demos.basedi.baseviewmodules.baseViewModules
import com.example.android.ecommerce.di.dbmodules.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(listOf(dbModule, baseViewModules))
        }
    }
}