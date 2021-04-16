package com.example.android.common.baseutils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import com.example.android.common.baseapp.BaseActivity
import com.example.android.common.baselisteners.Callbacks


/**
 * 2/20/2021 11:37
 * <p>
 * This gives [Callbacks.RegistrationCallback] to [BaseActivity] which we use in
 * [BaseActivity.onCreate] and in [BaseActivity.onPause], [BaseActivity.onStop]
 * or in [BaseActivity.onDestroy].
 * </p>
 * [ConnectivityProvider] implements [Callbacks.RegistrationCallback].
 * We are calling abstract methods of [Callbacks.RegistrationCallback] in [BaseActivity]
 * to register or unregister event listening (receiver) of network change.
 * </p>
 * [ConnectivityProvider] uses different APIs for the backward compatibility to give proper network changes.
 * </p>
 * So, the client (caller or user class of this [ConnectivityProvider] and [Callbacks.RegistrationCallback]) which is
 * [BaseActivity], does not know about different management for different APIs for the backward compatibility and all they care
 * is to call the right method at right time and it will be called in whoever has implemented it and is suited
 * based on device version.
 * </p>
 * [ConnectivityProvider] is a singleton class that uses [android.content.Context] and
 * [Callbacks.NetworkCallback] to give network changes.
 * </p>
 * So, [ConnectivityProvider] is giving (a way, bridge to reach and trigger, call) the implementation of an interface
 * [Callbacks.RegistrationCallback] and on the other hand, it takes the [Callbacks.NetworkCallback] interface
 * implementation itself so that it can call its method [Callbacks.NetworkCallback.onNetworkStateChange] accordingly.
 * </p>
 * Based on device version, [ConnectivityProvider] gives [Callbacks.RegistrationCallback]
 * that we are using in [BaseActivity] in form of [BaseActivity.networkRegistration] via either
 * [com.example.android.common.baseutils.NetworkCallback] or via
 * [com.example.android.common.baseutils.NetworkReceiver].
 * </p>
 * That means, both [com.example.android.common.baseutils.NetworkCallback] and
 * [com.example.android.common.baseutils.NetworkReceiver] also returns
 * [Callbacks.RegistrationCallback] which we are getting via [ConnectivityProvider]
 * in form of [BaseActivity.networkRegistration].
 * </p>
 * If device version is N (7) or above, we are getting [BaseActivity.networkRegistration]
 * through [com.example.android.common.baseutils.NetworkCallback] otherwise
 * through [com.example.android.common.baseutils.NetworkReceiver].
 * </p>
 * So, based on device version, wherever we have implemented our [BaseActivity.networkRegistration]
 * interface, either in [com.example.android.common.baseutils.NetworkReceiver] or in
 * [com.example.android.common.baseutils.NetworkCallback], we will call (use) it from
 * the [BaseActivity] and we will call [Callbacks.RegistrationCallback.onRegister]
 * in [BaseActivity.onCreate] and [Callbacks.RegistrationCallback.onUnregister] in [BaseActivity.onDestroy], [BaseActivity.onPause]
 * or in [BaseActivity.onStop].
 * </p>
 * This is the benefit of casting to interface and using them without exposing anything else
 * that the underlying object or class has.
 * </p>
 * What we care is [Callbacks.RegistrationCallback.onRegister] and [Callbacks.RegistrationCallback.onUnregister]
 * and what we do not care is in knowing who implements [Callbacks.RegistrationCallback] and anything else
 * about whoever implements [Callbacks.RegistrationCallback].
 * </p>
 * For example, `interface I` has `doIStuff`, `class A: I`, `class B: I`
 * and now we want to call `doIStuff` from `class C` without exposing irrelevant things
 * of any class that implements `interface I`. We don't need more, there is no need to have
 * the whole `class A` or `class B`. We are very specific here and it is known as
 * interface segregation principle.
 * </p>
 * For more information on SOLID and interface segregation, please check the provided links.
 * </p>
 *
 *
 * </p>
 * @author srdpatel
 * [InterfaceSegregationPrinciple] (https://en.wikipedia.org/wiki/Interface_segregation_principle "Interface segregation principle")
 * [SOLID Stackify](https://stackify.com/interface-segregation-principle/ "SOLID Stackify")
 * @since 1.0.0
 */
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