package com.example.android.common.nav

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.example.android.common.R
import com.example.android.common.baseapp.BaseFragment
import com.example.android.common.baseviewmodels.BaseViewModel
import com.example.android.common.databinding.ComSignInFragmentBinding

class ComSignInFragment: BaseFragment<ComSignInFragmentBinding, BaseViewModel>(R.layout.com_sign_in_fragment) {

    private lateinit var dataBinding: ComSignInFragmentBinding

    override val viewModel: BaseViewModel by activityViewModels()

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as ComSignInFragmentBinding
    }

    override fun otherStuffs() {

    }
}