package com.example.android.common.baseviewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.common.basestate.StateLogInSignUpForm
import org.koin.core.KoinComponent

open class BaseFormViewModel : BaseViewModel(), KoinComponent {

    private val state : MutableLiveData<StateLogInSignUpForm> = MutableLiveData(StateLogInSignUpForm.InitialDefault)

    fun getState() : LiveData<StateLogInSignUpForm> = state
}