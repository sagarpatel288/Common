package com.example.android.common.basestate

import com.example.android.common.basemodels.BaseResponse

sealed class LogInSignUpFormState {
    object InitialDefault : LogInSignUpFormState()
    object EmailIsEmpty : LogInSignUpFormState()
    object EmailIsInvalid : LogInSignUpFormState()
    object PasswordIsEmpty : LogInSignUpFormState()
    object PasswordIsInvalid : LogInSignUpFormState()
    object PasswordIsShort : LogInSignUpFormState()
    object PasswordDoesNotMatch : LogInSignUpFormState()
    object UniqueIdIsEmpty : LogInSignUpFormState()
    object UniqueIdInvalid : LogInSignUpFormState()
    object Loading : LogInSignUpFormState()
    data class Result(val result: BaseResponse<*>) : LogInSignUpFormState()
}