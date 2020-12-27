package com.example.android.common.basestate

import com.example.android.common.basedto.BaseResponse

sealed class BaseState {

    sealed class Validation : BaseState() {
        // comment by srdpatel: 4/13/2020 add other validations like name, firstName, middleName, lastName etc... as we need
        object InitialDefault : Validation()
        object EmailIsEmpty : Validation()
        object EmailIsInvalid : Validation()
        object PasswordIsEmpty : Validation()
        object PasswordIsInvalid : Validation()
        object PasswordIsShort : Validation()
        object PasswordDoesNotMatch : Validation()
        object UniqueIdIsEmpty : Validation()
        object UniqueIdInvalid : Validation()
    }

    object Idle : BaseState() //Stable, Initial, Idle
    object Load : BaseState() //Load, Run, Fire, Execute, Fetch
    object Loading : BaseState() //Loading, Running, Fetching
    object Finished : BaseState() //Fetched, Finished
    object Ok : BaseState() //success, done, pass, positive
    data class Result(val result: BaseResponse) : BaseState() //Response
}