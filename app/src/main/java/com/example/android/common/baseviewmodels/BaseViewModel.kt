package com.example.android.common.baseviewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.common.basestate.BaseState
import org.koin.core.KoinComponent

/*add dependency and use ViewModel(state: SavedStateHandle) to survive process death*/
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

    /**
     * 2/18/2021 19:34
     * <p>
     * We keep the mutable live data private and in order to access it,
     * we use another property [someLiveData], make it liveData instead of mutableLiveData and
     * override its getter method to return our mutableLiveData.
     * </p>
     * @author srdpatel
     * @since 1.0.0
     */
    private var someMutableLiveData = MutableLiveData<String>()

    /**
     * 2/18/2021 23:01
     * We use this kind of public live data for one way binding or observation.
     *
     * @author srdpatel
     * @since 1.0.0
     */
    val someLiveData: LiveData<String>
        get() = someMutableLiveData

    /**
     * 2/18/2021 22:54
     * Live data for two way data binding must be mutable and public like this [twoWayDataBinding].
     * Live data for one way data binding can be immutable and public just like [someLiveData].
     * We can bind [twoWayDataBinding] to an edit text.
     *
     * @author srdpatel
     * @since 1.0.0
     */
    val twoWayDataBinding = MutableLiveData<String>()
}