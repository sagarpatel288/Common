package com.example.android.common.baseapp

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.android.common.basestate.BaseState
import com.example.android.common.baseviewmodels.BaseFormViewModel
import org.koin.android.viewmodel.ext.android.viewModel

abstract class BaseFormActivity : BaseActivity<ViewDataBinding, BaseFormViewModel>(0) {

    override val viewModel: BaseFormViewModel by viewModel()

    private val observer = Observer<BaseState> {
        onChangeState(it)
    }

    open fun onChangeState(it: BaseState?) {

    }

    override fun setObservers() {
        viewModel.state().observe(this, observer)
    }
}