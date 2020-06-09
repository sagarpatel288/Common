package com.example.android.common.basestate

import com.example.android.common.basedto.BaseResponse

sealed class BaseState {
    data class Result(val result: BaseResponse<*>) : BaseState()
}