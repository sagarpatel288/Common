package com.example.android.common.basemodels

import retrofit2.HttpException
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class ResponseHandler {

    /**
     * 3/7/2020
     * [Resource] is a data class and [Resource.success] is a static method there.
     * <p>
     *
     * </p>
     *  {@link #} []
     *
     * @param
     * @return
     * @author srdpatel
     * @see <a href="http://google.com"></a>
     * [] (http://google.com "")
     * @since 1.0
     */
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    /**
     * 3/7/2020
     * [Resource] is a data class and [Resource.error] is a static method
     * <p>
     *
     * </p>
     *  {@link #} []
     *
     * @author srdpatel
     * @see <a href="http://google.com"></a>
     * [ReadableHyperlinkText]( "")
     * @since 1.0
     */
    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(getErrorMessage(e.code()), null)
            is SocketTimeoutException -> Resource.error(getErrorMessage(ErrorCodes.SocketTimeOut.code), null)
            else -> Resource.error(getErrorMessage(Int.MAX_VALUE), null)
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
