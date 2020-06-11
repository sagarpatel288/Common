package com.example.android.common.basestate

import com.example.android.common.basedto.BaseResponse

sealed class StateLogInSignUpForm {
    // comment by srdpatel: 4/13/2020 add other validations like name, firstName, middleName, lastName etc... as we need
    object InitialDefault : StateLogInSignUpForm()
    object EmailIsEmpty : StateLogInSignUpForm()
    object EmailIsInvalid : StateLogInSignUpForm()
    object PasswordIsEmpty : StateLogInSignUpForm()
    object PasswordIsInvalid : StateLogInSignUpForm()
    object PasswordIsShort : StateLogInSignUpForm()
    object PasswordDoesNotMatch : StateLogInSignUpForm()
    object UniqueIdIsEmpty : StateLogInSignUpForm()
    object UniqueIdInvalid : StateLogInSignUpForm()
    object Loading : StateLogInSignUpForm()
    object Ok: StateLogInSignUpForm()
    object False: StateLogInSignUpForm()
    data class Result(val result: BaseResponse) : StateLogInSignUpForm()
}