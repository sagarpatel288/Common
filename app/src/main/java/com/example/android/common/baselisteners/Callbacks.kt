package com.example.android.common.baselisteners

import android.content.Intent

abstract class Callbacks {

    interface Callback {
        fun onEventCallBack(intent: Intent)
    }
}