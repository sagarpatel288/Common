package com.example.android.common.basestate

import com.example.android.common.basedto.SampleResponse

sealed class BaseState {

    sealed class Validation : BaseState() {
        // comment by srdpatel: 4/13/2020 add other validations like name, firstName, middleName, lastName etc... as we need
        object INITIAL_DEFAULT : Validation()
        object EMAIL_IS_EMPTY : Validation()
        object EMAIL_IS_INVALID : Validation()
        object PASSWORD_IS_EMPTY : Validation()
        object PASSWORD_IS_INVALID : Validation()
        object PASSWORD_IS_SHORT : Validation()
        object PASSWORD_DOES_NOT_MATCH : Validation()
        object UNIQUE_ID_IS_EMPTY : Validation()
        object UNIQUE_ID_INVALID : Validation()
    }

    object IDLE : BaseState() //Stable, Initial, Idle
    object LOAD : BaseState() //Load, Run, Fire, Execute, Fetch
    object LOADING : BaseState() //Loading, Running, Fetching
    object FINISHED : BaseState() //Fetched, Finished
    object SUCCESS : BaseState() //success, done, pass, positive
    object ERROR : BaseState() //fail, error, negative

    data class Result(val result: SampleResponse) : BaseState() //Response
}