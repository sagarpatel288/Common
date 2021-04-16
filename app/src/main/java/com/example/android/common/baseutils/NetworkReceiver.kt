package com.example.android.common.baseutils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.android.common.baselisteners.Callbacks
import timber.log.Timber

/**
 * 2/20/2021 17:50
 * <p>
 * This class [NetworkReceiver] is backward compatible to detect changes in network asynchronously (and not instant, that is why
 * it is deprecated now).
 * </p>
 * This class [NetworkReceiver] uses [android.content.Context] and [Callbacks.NetworkCallback].
 * We are using [android.content.Context] to get [ConnectivityManager] and
 * We are using [Callbacks.NetworkCallback] to send changes in network detected here to the implementation of [Callbacks.NetworkCallback].
 * </p>
 * This class extends [BroadcastReceiver] and implements [Callbacks.RegistrationCallback].
 * [com.example.android.common.baseapp.BaseActivity] uses interface reference of [Callbacks.RegistrationCallback] from this class
 * via [ConnectivityProvider] if the device is running android version 6 (Marshmallow, Api 23) or below.
 * </p>
 * So, [com.example.android.common.baseapp.BaseActivity] calls methods of [Callbacks.RegistrationCallback] that we have implemented
 * here and this class [NetworkReceiver] calls methods of [Callbacks.NetworkCallback] that we have implemented in
 * [com.example.android.common.baseapp.BaseActivity].
 * </p>
 * @author srdpatel
 * @since 1.0.0
 */
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

        // comment by srdpatel: 2/21/2021 Deprecated in Api 15
        /*https://developer.android.com/reference/android/net/ConnectivityManager#EXTRA_NETWORK_INFO*/
        val fallbackNetworkInfo: NetworkInfo? =
            intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO)

        Timber.d("NetworkReceiver: :onReceive: isConnected: ${networkInfo?.isConnected} :and isAvailable: ${networkInfo?.isAvailable}")

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