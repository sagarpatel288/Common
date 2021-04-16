package com.example.android.common.baseutils

import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.android.common.baselisteners.Callbacks

/**
 * 2/20/2021 17:28
 * <p>
 * This class [NetworkCallback] implements [ConnectivityManager.NetworkCallback] and overrides its methods to detect
 * changes in network and it sends these changes in network to [com.example.android.common.baseapp.BaseActivity] via
 * [ConnectivityProvider].
 * </p>
 * This class gives [Callbacks.RegistrationCallback] as a [com.example.android.common.baseapp.BaseActivity.networkRegistration]
 * to [com.example.android.common.baseapp.BaseActivity].
 * </p>
 * With the help of [ConnectivityProvider], [com.example.android.common.baseapp.BaseActivity] is getting [Callbacks.RegistrationCallback] either from here
 * which is [NetworkCallback] if the device has android version 5 (Lollipop, Api 21) or from
 * [NetworkReceiver] if the device has android version 7 (Nougat, Api 24 or above) depending upon device version.
 * </p>
 * [com.example.android.common.baseapp.BaseActivity] does not know about the implementation but it is going to have
 * [Callbacks.RegistrationCallback] interface reference using which it calls [Callbacks.RegistrationCallback.onRegister] and
 * [Callbacks.RegistrationCallback.onUnregister] to register or unregister the receiver listening to the event/s of network changes.
 * </p>
 * When [com.example.android.common.baseapp.BaseActivity] calls [Callbacks.RegistrationCallback.onRegister] or
 * [Callbacks.RegistrationCallback.onUnregister], we get it here via [ConnectivityProvider].
 * </p>
 * Similarly, this class [NetworkCallback] does not know about the implementation of [Callbacks.NetworkCallback] but it has got it
 * and it calls appropriate methods that is available wherever there is actual implementation of [Callbacks.NetworkCallback] which is
 * available in [com.example.android.common.baseapp.BaseActivity].
 * </p>
 * So, through [networkCallback] that this class is getting from [com.example.android.common.baseapp.BaseActivity] via
 * [ConnectivityProvider], this class [NetworkCallback] sends events of network changes which is being received by
 * [com.example.android.common.baseapp.BaseActivity].
 * </p>
 *
 * @author srdpatel
 * [] (http://google.com "")
 * @since 1.0.0
 */
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
        // comment by srdpatel: 2/20/2021 Why there is a mismatch in register and unregister?
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