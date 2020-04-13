package com.example.android.common.baseapp

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.android.common.basestate.StateLogInSignUpForm
import com.example.android.common.baseviewmodels.BaseFormViewModel
import org.koin.android.viewmodel.ext.android.viewModel

abstract class BaseFormActivity : BaseActivity<ViewDataBinding, BaseFormViewModel>(0) {

    override val viewModel: BaseFormViewModel by viewModel()

    private val observer = Observer<StateLogInSignUpForm> {
        onChangeState(it)
    }

    open fun onChangeState(it: StateLogInSignUpForm?) {

    }

    override fun setObservers() {
        viewModel.getState().observe(this, observer)
    }
}