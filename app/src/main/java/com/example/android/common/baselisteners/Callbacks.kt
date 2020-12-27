package com.example.android.common.baselisteners

import android.content.Intent
import com.example.android.common.basedto.BaseResponse
import com.example.android.common.basestate.BaseState

abstract class Callbacks {

    interface StatusCallback {
        fun onIdle(baseState: BaseState)
        fun onLoading(baseState: BaseState)
        fun onFinished(baseState: BaseState)
        fun onResult(result: BaseState)
    }

    interface EventCallback {
        fun onEventCallBack(intent: Intent)
    }

    interface RegistrationCallback {
        fun onRegister()
        fun onUnregister()
    }

    interface NetworkCallback {
        fun onNetworkStateChange(hasInternet: Boolean)
    }

    interface ResponseCallback {
        fun onResponse(response: BaseResponse, extra: Any?)
    }
}