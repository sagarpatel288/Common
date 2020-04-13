package com.example.android.common.basedi.baseviewmodules

import com.example.android.common.baseviewmodels.BaseFormViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val baseViewModules = module {

    viewModel {
        BaseFormViewModel()
    }
}