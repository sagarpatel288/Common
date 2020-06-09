package com.example.android.common.basedi.baseSharedPrefsModule

import android.content.Context
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val baseSharePrefModule = module {

    // comment by srdpatel: 6/7/2020 single means singleton
    single {
        androidApplication().getSharedPreferences("app_pref", Context.MODE_PRIVATE)
    }
}