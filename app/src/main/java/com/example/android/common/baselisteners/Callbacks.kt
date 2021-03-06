package com.example.android.common.baselisteners

import android.content.Intent
import com.example.android.common.basedto.SampleResponse
import com.example.android.common.basestate.BaseState

abstract class Callbacks {

    interface StatusCallback {
        fun onIdle(baseState: BaseState) {

        }
        fun onLoading(baseState: BaseState) {

        }
        fun onFinished(baseState: BaseState){

        }
        fun onResult(result: BaseState){

        }
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
        fun onResponse(response: SampleResponse, extra: Any?)
    }

    /**
     * Interface callback from [MyAlertDialog] to host
     *
     *
     * Gives callback to host for whether [MyAlertDialog.btnLeft] or [MyAlertDialog.btnRight] has clicked
     *
     *
     *
     * @since 1.0
     */
    interface OnDialogBtnClick {
        fun onLeftBtnClick()
        fun onRightBtnClick()
    }
}