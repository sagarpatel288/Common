package com.example.android.common.basenetworking

import retrofit2.HttpException
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class BaseResponseHandler {
    fun <T> handleSuccess(data: T): BaseResponse<T> {
        return BaseResponse.success(data)
    }

    fun handleException(throwable: Throwable): BaseResponse<Nothing> {
        return when (throwable) {
            is HttpException -> BaseResponse.error(
                false,
                throwable.code(),
                getErrorMessage(throwable.code()),
                throwable.response()?.errorBody()
            )
            is SocketTimeoutException -> BaseResponse.error(
                true,
                ErrorCodes.SocketTimeOut.code,
                getErrorMessage(ErrorCodes.SocketTimeOut.code),
                null
            )
            else -> BaseResponse.error(
                true,
                Int.MAX_VALUE,
                getErrorMessage(Int.MAX_VALUE),
                null
            )
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Timeout"
            401 -> "Unauthorised"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}
