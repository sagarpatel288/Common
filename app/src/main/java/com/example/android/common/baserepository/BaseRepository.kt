package com.example.android.common.baserepository

import com.example.android.common.basenetworking.BaseResponse
import com.example.android.common.basenetworking.BaseResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepository : KoinComponent {

    private val baseResponseHandler: BaseResponseHandler by inject()

    /**
     * 12/27/2020 13:03
     * <p>
     * [safeApiCall] is a higher order function that accepts another function as a parameter.
     * The argument function must return [T].
     * <p>
     * This common [safeApiCall] makes all the api calls on [Dispatchers.IO] so that we do not have
     * to write it for each and every api calls.
     * <p>
     * The common [safeApiCall] also handles success and failure responses for us so that we do not
     * have to write it for each and every api calls.
     * <p>
     * It it is a successful response, we take (get) our data and run away (leave everything else
     * on this method to manage).
     * </p>
     *
     * @author srdpatel
     * @see <a href="http://google.com"></a>
     * @since 1.0
     */
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): BaseResponse<T> {
        return withContext(Dispatchers.IO) {
            try {
                baseResponseHandler.handleSuccess(apiCall.invoke())
            } catch (throwable: Throwable) {
                baseResponseHandler.handleException(throwable)
            }
        }
    }
}