package com.example.android.common.baseviewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.common.basestate.BaseState
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    /**
     * 4/11/2020
     * comment by srdpatel: 4/6/2020 This is the only mutable live data that is being observed by view
     * <p>
     * Best practices for mvvm says that we should not expose mutable live data to view.
     * To understand why private val and getting it through [state], check the link.
     * </p>
     *  {@link #} []
     *
     * @author srdpatel
     * @see <a href="comment by srdpatel: 4/6/2020 This is the only mutable live data that is being observed by view">Best practices for mvvm</a>
     * [Do not expose mutable data to view](https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb "Best practices for MVVM")
     * @since 1.0
     */
    val state = MutableLiveData<BaseState>(BaseState.IDLE)

    /**
     * 4/11/2020
     * comment by srdpatel: 12/3/2019 static method that returns static final variable [state]
     * <p>
     * Best practices for mvvm says that we should not expose mutable live data to view.
     * To understand why private val and getting it through [state], check the link.
     * </p>
     *  {@link #} []
     *
     * @author srdpatel
     * @see <a href="comment by srdpatel: 4/6/2020 This is the only mutable live data that is being observed by view">Best practices for mvvm</a>
     * [Do not expose mutable data to view](https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb "Best practices for MVVM")
     * @since 1.0
     */
    fun state(): LiveData<BaseState> = state
}