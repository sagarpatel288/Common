package com.example.android.common.nav

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.example.android.common.R
import com.example.android.common.baseapp.BaseFragment
import com.example.android.common.baseviewmodels.BaseViewModel
import com.example.android.common.databinding.ComSignUpFragmentBinding

class ComSignUpFragment: BaseFragment<ComSignUpFragmentBinding, BaseViewModel>(R.layout.com_sign_up_fragment) {

    private lateinit var dataBinding: ComSignUpFragmentBinding

    override val viewModel: BaseViewModel by activityViewModels()

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as ComSignUpFragmentBinding
    }

    override fun otherStuffs() {

    }
}