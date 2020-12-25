package com.example.android.common.baseutils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import com.example.android.common.baselisteners.Callbacks

object ConnectivityProvider {

    fun getConnectivityProvider(
        context: Context,
        networkCallback: Callbacks.NetworkCallback
    ): Callbacks.RegistrationCallback {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            NetworkCallback(connectivityManager, networkCallback)
        } else {
            NetworkReceiver(context, networkCallback)
        }
    }
}