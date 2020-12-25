package com.example.android.common.baselisteners

import android.content.Intent

abstract class Callbacks {

    interface Callback {
        fun onEventCallBack(intent: Intent)
    }

    interface RegistrationCallback {
        fun onRegister()
        fun onUnregister()
    }

    interface NetworkCallback {
        fun onNetworkStateChange(hasInternet: Boolean)
    }
}