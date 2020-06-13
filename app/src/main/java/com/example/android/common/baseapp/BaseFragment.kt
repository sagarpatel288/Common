package com.example.android.common.baseapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.android.common.BR
import com.example.android.common.baseviewmodels.BaseViewModel

/**
 * 4/10/2020
 *
 * <p>
 *
 * </p>
 *  {@link #} []
 *
 * @author srdpatel
 * @see <a href="https://developer.android.com/topic/libraries/data-binding/expressions">How to use databinding for fragments and recyclerViews</a>
 * [Databinding for fragments and list adapters](https://developer.android.com/topic/libraries/data-binding/expressions "How to use databinding for fragments and recyclerViews")
 * @since 1.0
 */
abstract class BaseFragment<VDB : ViewDataBinding, BVM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    abstract val viewModel: BVM
    private lateinit var dataBinding: VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return dataBinding.root
    }

    /**
     * 4/11/2020
     * Use [getViewLifecycleOwner] instead of this [BaseFragment] to avoid leakage and overhead of live data
     * <p>
     * Many times fragment is re-attached and not destroyed, especially during configuration changes like rotation.
     * But that doesn't mean that we want brand new this fragment [BaseFragment] as an observer every time.
     * However, live data will never release old fragment as it is not yet destroyed and it will also add new observer
     * due to configuration change and re-attachment of this fragment [BaseFragment].
     * Hence, it is better to use [getViewLifecycleOwner] instead of this fragment [BaseFragment] so that it syncs, supports and
     * cooperates with [viewModel] and live data the way we want.
     * </p>
     *
     * @author srdpatel
     * @see <a href="https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb#eeb0">Best practices for mvvm</a>
     * [Best practices for mvvm](https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb#eeb0 "Best practices for mvvm")
     * @since 1.0
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.setVariable(getBindingVariable(), viewModel)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.executePendingBindings()
        dataBinding(dataBinding)
        otherStuffs()
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

    abstract fun dataBinding(dataBinding: ViewDataBinding)

    abstract fun otherStuffs()
}