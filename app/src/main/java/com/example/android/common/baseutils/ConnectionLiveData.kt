package com.example.android.common.baseutils;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver
import android.content.Context;
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.net.*
import android.os.Build;
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData

/**
 * 2/20/2021 18:09
 * <p>
 * Set observer on this class [ConnectionLiveData] to get update whenever there is a change in network.
 * </p>
 * [com.example.android.common.baseapp.BaseActivity] is observing this [ConnectionLiveData] in
 * [com.example.android.common.baseapp.BaseActivity.observeInternetAvailability].
 * </p>
 * This class extends [LiveData] and overrides two methods: [onActive] and [onInactive].
 * This class, uses [ConnectivityManager] and [ConnectivityManager.NetworkCallback] to detect
 * changes in network.
 * This class uses different APIs [ConnectivityManager.NetworkCallback] for different android versions such as for android version 7, 6, 5 and below.
 * </p>
 * This class also uses [networkReceiver] which is a global broadcast receiver to asynchronously receive
 * changes in network for devices having android version 4 (Kitkat, Api 20) and below.
 * </p>
 * When we are using [networkReceiver] [BroadcastReceiver], we are required to register
 * [android.content.Context.registerReceiver] and unregister them by [android.content.Context.unregisterReceiver]
 * at proper lifecycle time to prevent leakage and NPE.
 * </p>
 * If the android version in device is 5 (Lollipop), it uses [getConnectivityLollipopManagerCallback]
 * that detects whether the network is available or not in [ConnectivityManager.NetworkCallback.onAvailable]
 * and in [ConnectivityManager.NetworkCallback.onLost] via [ConnectivityManager.NetworkCallback]..
 * </p>
 * If the android version in device is 6 (Marshmallow), it uses [getConnectivityMarshmallowManagerCallback]
 * that detects whether the network is available or not in [ConnectivityManager.NetworkCallback.onCapabilitiesChanged]
 * and in [ConnectivityManager.NetworkCallback.onLost] via [ConnectivityManager.NetworkCallback].
 * </p>
 * When we are using [ConnectivityManager.NetworkCallback], we are required to register
 * [ConnectivityManager.registerNetworkCallback] and [ConnectivityManager.unregisterNetworkCallback].
 * </p>
 * Both [getConnectivityLollipopManagerCallback] and [getConnectivityMarshmallowManagerCallback] uses
 * [networkRequestBuilder] while registering network callback [ConnectivityManager.registerNetworkCallback].
 * </p>
 * If the android version in device is 7 (Nougat) or above, it uses [getConnectivityMarshmallowManagerCallback]
 * that detects whether the network is available or not in [ConnectivityManager.NetworkCallback.onCapabilitiesChanged]
 * and in [ConnectivityManager.NetworkCallback.onLost] via [ConnectivityManager.registerDefaultNetworkCallback].
 * </p>
 *
 * @author srdpatel
 * [CONNECTIVITY_ACTION is deprecated] (https://stackoverflow.com/a/52718543/5492211 "CONNECTIVITY_ACTION is deprecated, what to use?")
 * @since 1.0.0
 */
class ConnectionLiveData(val context: Context) : LiveData<Boolean>() {

    // comment by srdpatel: 2/20/2021 We use connectivityManager.NetworkCallback or connectivityManager.registerDefaultNetworkCallback
    // based on android version in device
    private var connectivityManager: ConnectivityManager =
        context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    // comment by srdpatel: 2/20/2021 We use connectivityManager.NetworkCallback or connectivityManager.registerDefaultNetworkCallback
    // based on android version in device
    private lateinit var connectivityManagerCallback: ConnectivityManager.NetworkCallback

    // comment by srdpatel: 2/20/2021 We need networkRequestBuilder while registering network callback for connectivityManager
    // via connectivityManager.registerNetworkcallback.
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private val networkRequestBuilder: NetworkRequest.Builder = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)

    // comment by srdpatel: 2/20/2021 LiveData start point when someone begins to observe this live data.
    override fun onActive() {
        super.onActive()
        updateConnection()
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> connectivityManager.registerDefaultNetworkCallback(
                getConnectivityMarshmallowManagerCallback()
            )
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> marshmallowNetworkAvailableRequest()
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> lollipopNetworkAvailableRequest()
            else -> {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    context.registerReceiver(
                        networkReceiver,
                        IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
                    ) // android.net.ConnectivityManager.CONNECTIVITY_ACTION
                }
            }
        }
    }

    // comment by srdpatel: 2/20/2021 Live data end point when there is no observer.
    override fun onInactive() {
        super.onInactive()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.unregisterNetworkCallback(connectivityManagerCallback)
        } else {
            context.unregisterReceiver(networkReceiver)
        }
    }

    // comment by srdpatel: 2/20/2021 When using connectivityManager.NetworkCallback, we are required to
    // register and unregister our callbacks at proper time (lifecycle state).
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun lollipopNetworkAvailableRequest() {
        connectivityManager.registerNetworkCallback(
            networkRequestBuilder.build(),
            getConnectivityLollipopManagerCallback()
        )
    }

    // comment by srdpatel: 2/20/2021 When using connectivityManager.NetworkCallback, we are required to
    // register and unregister our callbacks at proper time (lifecycle state).
    @TargetApi(Build.VERSION_CODES.M)
    private fun marshmallowNetworkAvailableRequest() {
        connectivityManager.registerNetworkCallback(
            networkRequestBuilder.build(),
            getConnectivityMarshmallowManagerCallback()
        )
    }

    // comment by srdpatel: 2/20/2021 For android version 5 (lollipop), we get required network changes (internet) in
    // onAvailable and in onLost methods of connectivityManager.NetworkCallback
    private fun getConnectivityLollipopManagerCallback(): ConnectivityManager.NetworkCallback {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManagerCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    postValue(true)
                }

                override fun onLost(network: Network) {
                    postValue(false)
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    networkCapabilities.let { capabilities ->
                        if (capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && capabilities.hasCapability(
                                NetworkCapabilities.NET_CAPABILITY_VALIDATED
                            )
                        ) {
                            postValue(true)
                        }
                    }
                }
            }
            return connectivityManagerCallback
        } else {
            throw IllegalAccessError("Accessing wrong API version")
        }
    }

    // comment by srdpatel: 2/20/2021 For android version 6 (Marshmallow), we get required network changes (internet) in
    // onCapabilitiesChanges and in onLost methods of connectivityManager.NetworkCallback
    private fun getConnectivityMarshmallowManagerCallback(): ConnectivityManager.NetworkCallback {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManagerCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    networkCapabilities.let { capabilities ->
                        if (capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && capabilities.hasCapability(
                                NetworkCapabilities.NET_CAPABILITY_VALIDATED
                            )
                        ) {
                            postValue(true)
                        }
                    }
                }

                override fun onLost(network: Network) {
                    postValue(false)
                }
            }
            return connectivityManagerCallback
        } else {
            throw IllegalAccessError("Accessing wrong API version")
        }
    }

    // comment by srdpatel: 2/20/2021 We use global broadcast receiver to detect changes in network
    // if the android version in the device is below lollipop (5).
    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            updateConnection()
        }
    }

    // comment by srdpatel: 2/20/2021 This is the default state of the network.
    private fun updateConnection() {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        postValue(activeNetwork?.isConnected == true)
    }
}