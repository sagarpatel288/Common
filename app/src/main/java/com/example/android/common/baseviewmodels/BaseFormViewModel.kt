package com.example.android.common.baseviewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.common.basestate.BaseState
import org.koin.core.KoinComponent

open class BaseFormViewModel : BaseViewModel(), KoinComponent {

    private val state : MutableLiveData<BaseState> = MutableLiveData(BaseState.IDLE)

    fun getState() : LiveData<BaseState> = state
}