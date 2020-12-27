package com.example.android.common.baseapp.permission

import androidx.databinding.ViewDataBinding
import com.example.android.common.R
import com.example.android.common.baseapp.BaseActivity
import com.example.android.common.databinding.ActivityPermissionBinding
import org.koin.android.ext.android.inject

class PermissionActivity :
    BaseActivity<ActivityPermissionBinding, PermissionViewModel>(R.layout.activity_permission) {

    override val viewModel: PermissionViewModel by inject()
    lateinit var dataBinding: ActivityPermissionBinding

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as ActivityPermissionBinding
    }

    override fun setObservers() {

    }

    override fun beforeObserver() {

    }
}