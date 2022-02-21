package com.example.android.common.baseapp

import android.content.res.Resources
import android.graphics.Point
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.android.common.BR
import com.example.android.common.baseconstants.LOG
import com.example.android.common.baseconstants.StaticConstants
import com.example.android.common.baselisteners.Callbacks
import com.example.android.common.basestate.BaseState
import com.example.android.common.baseutils.ConnectionLiveData
import com.example.android.common.baseutils.ConnectivityProvider
import com.example.android.common.baseviewmodels.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import timber.log.Timber


/**
 * 2/5/2020
 * <p>
 * We have used generic abstract class assuming that each and every class that extends this [BaseActivity] class will have
 * [VDB] and [BVM] or its relevant subtypes but with different values.
 * <p>
 * We use generics (parameterized type) when we want to implement same functionality (Add, remove, count).
 * Whereas, we use inheritance when we want to give a flexibility for the alteration of the common functionality.
 * This [BaseActivity] class uses both inheritance and generics together as we know there will be some kinds of
 * [VDB] and [BVM] (generics) but with different implementation (inheritance).
 * [Generics Vs Inheritance](https://stackoverflow.com/a/799395/5492211)
 * And we use composition with interface when we want to establish "has-a" relationship with dependency injection.
 * <p>
 * Our class is parameterized class and we have set constraints for accepting generics.
 * Any activity extending (inheriting) this [BaseActivity] class must pass two generic types [VDB] & [BVM].
 * [VDB] is something that is required while extending (inheriting) this [BaseActivity] class.
 * However, [VDB] is available only after we explicitly bind it with our [layoutResId].
 * We always set/assign the [VDB] in [onCreate] anyways using [layoutResId].
 * So, no point in using abstract var [VDB].
 * [layoutResId] will mostly different for each and every view class.
 * That's why, we have taken [VDB] as lateinit.
 * [viewModel] can be different for each and every view, that's why we have taken it as an abstract val.
 * <p>
 * 12/3/2019
 * Check provided links to understand generics and @LayoutRes annotation
 * <p>
 * This is for abstraction. We have enforced the architecture rules that each activity extending
 * this [BaseActivity] must have its viewModel, viewDataBinding and xml layout.
 * This is to reduce some boiler plate codes such as to get viewDataBinding, set lifeCycleOwner and
 * to set viewModel.
 * </p>
 *
 * @param VDB A generic type with restriction that it must extend [ViewDataBinding]
 * @param BVM A generic type with restriction that it must extend [BaseViewModel]
 * @see <a href="https://kotlinlang.org/docs/tutorials/kotlin-for-py/generics.html">Kotlin Generics</a>
 * [Generics](https://www.journaldev.com/1663/java-generics-example-method-class-interface)
 * [AndroidX: layout in the constructor of the activity](https://www.bignerdranch.com/blog/activity-and-fragment-layouts-with-androidx/)
 * @author srdpatel
 * @since 1.0
 */
abstract class BaseActivity<VDB : ViewDataBinding, BVM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity(), Callbacks.StatusCallback, Callbacks.NetworkCallback {

    //region // comment by srdpatel: 4/24/2021 Amazon chime sdk android kotlin github demo
    private val mutex = Mutex()
    private val uiScope = CoroutineScope(Dispatchers.Main)
    //endregion

    // The BroadcastReceiver that tracks network connectivity changes.
    private var manager: ConnectivityManager? = null
    private val connectionLiveDataBinding: ConnectionLiveData by lazy {
        ConnectionLiveData(this)
    }
    private var hasInternet: Boolean = false
    private val networkRegistration: Callbacks.RegistrationCallback by lazy {
        ConnectivityProvider.getConnectivityProvider(
            this, this
        )
    }

    /**
     * 4/11/2020
     * comment by srdpatel: 4/11/2020 abstract val in Kotlin serves like abstract getter method in Java
     * <p>
     *
     * </p>
     * @author srdpatel
     * @since 1.0
     */
    abstract val viewModel: BVM

    /**
     * 6/13/2020
     * [VDB]
     * @author srdpatel
     * @since 1.0
     */
    private lateinit var dataBinding: VDB

    /**
     * 2/20/2021 11:37
     * <p>
     * [ConnectivityProvider] implements [Callbacks.RegistrationCallback].
     * We are calling abstract methods of [Callbacks.RegistrationCallback] in [BaseActivity] here
     * to register or unregister event listening (receiver) of network change via [networkRegistration].
     * </p>
     * To detect network changes, we have used [networkRegistration].
     * [networkRegistration] is an interface [Callbacks.RegistrationCallback] that we are getting
     * through [ConnectivityProvider] because [ConnectivityProvider] uses different APIs
     * for the backward compatibility to give proper network changes.
     * </p>
     * [ConnectivityProvider] implements [Callbacks.RegistrationCallback].
     * </p>
     * [ConnectivityProvider] is a singleton class that uses [android.content.Context] and
     * [Callbacks.NetworkCallback] to give network changes.
     * </p>
     * So, [ConnectivityProvider] is giving (a way, bridge to reach and trigger (call)) the implementation of an interface
     * [Callbacks.RegistrationCallback] and on the other hand, it takes the [Callbacks.NetworkCallback] interface
     * implementation itself so that it can call its method [Callbacks.NetworkCallback.onNetworkStateChange] accordingly.
     * </p>
     * Based on device version, [ConnectivityProvider] gives [Callbacks.RegistrationCallback]
     * that we are using here in form of [networkRegistration] via either
     * [com.example.android.common.baseutils.NetworkCallback] or via
     * [com.example.android.common.baseutils.NetworkReceiver].
     * </p>
     * That means, both [com.example.android.common.baseutils.NetworkCallback] and
     * [com.example.android.common.baseutils.NetworkReceiver] also returns
     * [Callbacks.RegistrationCallback] which we are getting via [ConnectivityProvider]
     * in form of [networkRegistration].
     * </p>
     * If device version is N (7) or above, we are getting [networkRegistration]
     * through [com.example.android.common.baseutils.NetworkCallback] otherwise
     * through [com.example.android.common.baseutils.NetworkReceiver].
     * </p>
     * So, based on device version, wherever we have implemented our [networkRegistration]
     * interface, either in [com.example.android.common.baseutils.NetworkReceiver] or in
     * [com.example.android.common.baseutils.NetworkCallback], we will call (use) it from
     * here, the [BaseActivity] and we will call [Callbacks.RegistrationCallback.onRegister]
     * in [onCreate] and [Callbacks.RegistrationCallback.onUnregister] in [onDestroy], [onPause]
     * or in [onStop].
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getScreenSize()
        // comment by srdpatel: 2/20/2021 `networkRegistration` has been initialized lazy.
        // Registers BroadcastReceiver to track network connection changes.
        networkRegistration.onRegister()
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(getBindingVariable(), viewModel)
        dataBinding(dataBinding)
        observeInternetAvailability()
        beforeObserver()
        setObservers()
        afterObserver()
    }

    private fun observeInternetAvailability() {
        connectionLiveDataBinding.observe(this) {
            onNetworkStateChange(it)
        }
    }

    /**
     * 1/4/2021 17:43
     * Sets global constants for screen height and screen width
     *
     * @author srdpatel
     * @since 1.0
     */
    private fun getScreenSize() {
//        val display = context.getSystemService(Context.WINDOW_SERVICE).defaultDisplay
        val displayMetrics = DisplayMetrics()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val display = display
            display?.getRealMetrics(displayMetrics)
        } else {
            @Suppress("DEPRECATION")
            val display = windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(displayMetrics)
        }

        val displayMetricsHeightPixels = displayMetrics.heightPixels
        val displayMetricsWidthPixels = displayMetrics.widthPixels

        Log.d(
            " :BaseActivity: ",
            "getScreenSize: displayMetrics.heightPixels: $displayMetricsHeightPixels"
        )
        Log.d(
            " :BaseActivity: ",
            "getScreenSize: displayMetrics.widthPixels: $displayMetricsWidthPixels"
        )

        val size = Point()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display?.getRealSize(size)
        } else {
            @Suppress("DEPRECATION")
            display?.getSize(size)
        }

        val screenWidth: Int = size.x
        val screenHeight: Int = size.y

        Log.d(
            " :BaseActivity: ",
            "getScreenSize: displayMetrics.heightPixels: $screenWidth"
        )
        Log.d(
            " :BaseActivity: ",
            "getScreenSize: displayMetrics.widthPixels: $screenHeight"
        )

        StaticConstants.screenHeight = screenHeight
        StaticConstants.screenWidth = screenWidth

        /*if (hasNavigationBar(Resources.getSystem())) {
            StaticConstants.screenHeight = displayMetrics.heightPixels + getNavigationBarHeight()
        }*/
    }

    private fun hasNavigationBar(resources: Resources): Boolean {
        val id: Int = resources.getIdentifier("config_showNavigationBar", "bool", "android")
        return id > 0 && resources.getBoolean(id)
    }

    private fun getNavigationBarHeight(): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val displayMetrics = DisplayMetrics()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val display = display
                display?.getRealMetrics(displayMetrics)
            } else {
                @Suppress("DEPRECATION")
                val display = windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(displayMetrics)
            }

            val usableHeight = displayMetrics.heightPixels

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val display = display
                display?.getRealMetrics(displayMetrics)
            } else {
                @Suppress("DEPRECATION")
                val display = windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(displayMetrics)
            }

            val realHeight = displayMetrics.heightPixels
            return if (realHeight > usableHeight) realHeight - usableHeight else 0
        }
        return 0
    }

    open fun afterObserver() {

    }

    abstract fun dataBinding(dataBinding: ViewDataBinding)

    open fun setObservers(): Unit = viewModel.state().observe(this) { state -> renderState(state) }

    open fun renderState(state: BaseState?) {
        if (state is BaseState.IDLE) {
            onIdle(state)
        } else if (state is BaseState.LOAD || state is BaseState.LOADING) {
            onLoading(state)
        } else if (state is BaseState.FINISHED) {
            onFinished(state)
        }
    }

    /**
     * 4/11/2020
     * Gives flexibility to change binding variable in xml
     * <p>
     *
     * </p>
     *
     * @author srdpatel
     * @see <a href="https://github.com/MindorksOpenSource/android-mvvm-architecture/blob/master/app/src/main/java/com/mindorks/framework/mvvm/ui/base/BaseActivity.java">MindOrks Mvvm Sample</a>
     * [MindOrks Mvvm Sample](https://github.com/MindorksOpenSource/android-mvvm-architecture/blob/master/app/src/main/java/com/mindorks/framework/mvvm/ui/base/BaseActivity.java "MindOrksOpenSource Mvvm Sample")
     * @since 1.0
     */
    open fun getBindingVariable(): Int {
        return BR.viewModel
    }

    abstract fun beforeObserver()

    override fun onDestroy() {
        super.onDestroy()
        // Unregisters BroadcastReceiver when app is destroyed or during onPause?.
        networkRegistration.onUnregister()
    }

    fun hasInternet(): Boolean {
        return hasInternet
    }

    /**
     * 2/20/2021 11:37
     * <p>
     * [ConnectivityProvider] implements [Callbacks.RegistrationCallback].
     * We are calling abstract methods of [Callbacks.RegistrationCallback] in [BaseActivity] here
     * to register or unregister event listening (receiver) of network change via [networkRegistration].
     * </p>
     * This method [onNetworkStateChange] is from interface [Callbacks.NetworkCallback] that we have implemented in this [BaseActivity].
     * This method [onNetworkStateChange] gives [Boolean] value [hasInternet] whenever there is
     * a change in the state of network like from internet to no internet or vice versa.
     * </p>
     * To detect these kind of network changes, we have used [networkRegistration].
     * [networkRegistration] is an interface [Callbacks.RegistrationCallback] that we are getting
     * through [ConnectivityProvider] because [ConnectivityProvider] uses different APIs
     * for the backward compatibility to give proper network changes.
     * </p>
     * [ConnectivityProvider] implements [Callbacks.RegistrationCallback].
     * </p>
     * [ConnectivityProvider] is a singleton class that uses [android.content.Context] and
     * [Callbacks.NetworkCallback] to give network changes.
     * </p>
     * So, [ConnectivityProvider] is giving (a way, bridge to reach and trigger (call)) the implementation of an interface
     * [Callbacks.RegistrationCallback] and on the other hand, it takes the [Callbacks.NetworkCallback] interface
     * implementation itself so that it can call its method [Callbacks.NetworkCallback.onNetworkStateChange] accordingly.
     * </p>
     * Based on device version, [ConnectivityProvider] gives [Callbacks.RegistrationCallback]
     * that we are using here in form of [networkRegistration] via either
     * [com.example.android.common.baseutils.NetworkCallback] or via
     * [com.example.android.common.baseutils.NetworkReceiver].
     * </p>
     * That means, both [com.example.android.common.baseutils.NetworkCallback] and
     * [com.example.android.common.baseutils.NetworkReceiver] also returns
     * [Callbacks.RegistrationCallback] which we are getting via [ConnectivityProvider]
     * in form of [networkRegistration].
     * </p>
     * If device version is N (7) or above, we are getting [networkRegistration]
     * through [com.example.android.common.baseutils.NetworkCallback] otherwise
     * through [com.example.android.common.baseutils.NetworkReceiver].
     * </p>
     * So, based on device version, wherever we have implemented our [networkRegistration]
     * interface, either in [com.example.android.common.baseutils.NetworkReceiver] or in
     * [com.example.android.common.baseutils.NetworkCallback], we will call (use) it from
     * here, the [BaseActivity] and we will call [Callbacks.RegistrationCallback.onRegister]
     * in [onCreate] and [Callbacks.RegistrationCallback.onUnregister] in [onDestroy], [onPause]
     * or in [onStop].
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
    override fun onNetworkStateChange(hasInternet: Boolean) {
        this.hasInternet = hasInternet
        Timber.d(" :$LOG: BaseActivity: :onNetworkStateChange: $hasInternet")
    }
}