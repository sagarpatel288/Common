package com.example.android.common.baseutils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.android.common.baselisteners.Callbacks

@Suppress("DEPRECATION")
class NetworkReceiver(
    private val context: Context,
    private val networkCallback: Callbacks.NetworkCallback
) : BroadcastReceiver(), Callbacks.RegistrationCallback {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == null)
            return

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        // on some devices ConnectivityManager.getActiveNetworkInfo() does not provide the correct network state
        // https://issuetracker.google.com/issues/37137911

        val fallbackNetworkInfo: NetworkInfo? =
            intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO)

        val hasInternet: Boolean =
            if (networkInfo?.isConnectedOrConnecting == true) {
                networkInfo.isConnectedOrConnecting
            } else if (networkInfo != null && fallbackNetworkInfo != null &&
                networkInfo.isConnectedOrConnecting != fallbackNetworkInfo.isConnectedOrConnecting
            ) {
                fallbackNetworkInfo.isConnectedOrConnecting
            } else {
                val state = networkInfo ?: fallbackNetworkInfo
                state?.isConnectedOrConnecting ?: false
            }

        networkCallback.onNetworkStateChange(hasInternet)
    }

    override fun onRegister() {
        context.registerReceiver(this, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onUnregister() {
        TODO("Not yet implemented")
    }
}