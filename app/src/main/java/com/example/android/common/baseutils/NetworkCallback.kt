package com.example.android.common.baseutils

import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.android.common.baselisteners.Callbacks

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class NetworkCallback(
    private val connectivityManager: ConnectivityManager,
    private val networkCallback: Callbacks.NetworkCallback
) : ConnectivityManager.NetworkCallback(), Callbacks.RegistrationCallback {

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        super.onLosing(network, maxMsToLive)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        networkCallback.onNetworkStateChange(false)
    }

    override fun onUnavailable() {
        super.onUnavailable()
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        networkCallback.onNetworkStateChange(networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET))
    }

    override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
        super.onLinkPropertiesChanged(network, linkProperties)
    }

    override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
        super.onBlockedStatusChanged(network, blocked)
    }

    override fun onRegister() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(this)
        }
    }

    override fun onUnregister() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.unregisterNetworkCallback(this)
        }
    }
}