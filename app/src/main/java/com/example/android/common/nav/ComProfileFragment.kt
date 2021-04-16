package com.example.android.common.nav

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.example.android.common.R
import com.example.android.common.baseapp.BaseFragment
import com.example.android.common.baseviewmodels.BaseViewModel
import com.example.android.common.databinding.ComProfileFragmentBinding

class ComProfileFragment: BaseFragment<ComProfileFragmentBinding, BaseViewModel>(R.layout.com_profile_fragment) {

    private lateinit var dataBinding: ComProfileFragmentBinding

    override val viewModel: BaseViewModel by activityViewModels()

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as ComProfileFragmentBinding
    }

    override fun otherStuffs() {

    }
}