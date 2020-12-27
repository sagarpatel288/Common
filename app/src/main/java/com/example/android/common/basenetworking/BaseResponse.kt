package com.example.android.common.basenetworking

import com.example.android.common.basestate.BaseState
import okhttp3.ResponseBody

data class BaseResponse<out T>(
    val BaseState: BaseState,
    val data: T?,
    val id: Int?,
    val boolean: Boolean?,
    val message: String?,
    val responseBody: ResponseBody?
) {
    companion object {
        fun <T> success(data: T?): BaseResponse<T> {
            return BaseResponse(BaseState.SUCCESS, data, null, null, null, null)
        }

        fun <T> error(
            isNetworkError: Boolean,
            errorCode: Int?,
            msg: String,
            errorBody: ResponseBody?,
        ): BaseResponse<T> {
            return BaseResponse(BaseState.ERROR, null, errorCode, isNetworkError, msg, errorBody)
        }

        fun <T> loading(data: T?): BaseResponse<T> {
            return BaseResponse(BaseState.LOADING, data, null, null, null, null)
        }

        fun <T> empty(msg: String): BaseResponse<T> {
            return BaseResponse(BaseState.EMPTY, null, null, null, msg, null)
        }
    }
}
