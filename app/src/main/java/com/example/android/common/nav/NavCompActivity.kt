package com.example.android.common.nav

import androidx.databinding.ViewDataBinding
import com.example.android.common.R
import com.example.android.common.baseapp.BaseActivity
import com.example.android.common.baseviewmodels.BaseViewModel
import com.example.android.common.databinding.NavCompActivityBinding
import org.koin.android.viewmodel.ext.android.viewModel

class NavCompActivity: BaseActivity<NavCompActivityBinding, BaseViewModel>(R.layout.nav_comp_activity) {

    private lateinit var dataBinding: NavCompActivityBinding

    override val viewModel: BaseViewModel by viewModel()

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as NavCompActivityBinding
    }

    override fun beforeObserver() {

    }
}