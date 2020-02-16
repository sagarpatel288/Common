package com.example.android.demos.basedi.baseviewmodules

import com.example.android.demos.baseviewmodels.ActivityMainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val baseViewModules = module {

    viewModel {
        ActivityMainViewModel()
    }
}