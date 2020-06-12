package com.example.android.common.baseapp

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.android.common.BR

/**
 * 2/5/2020
 * <p>
 * Our class is parameterized class and we have set constraints for accepting generics.
 * Any activity extending (inheriting) this class must pass two generic types [VDB] & [BVM].
 * [VDB] is something that is required while extending (inheriting) this [BaseActivity] class.
 * However, [VDB] is available only after we explicitly bind it with our [layoutResId].
 * We always going to set/assign the [VDB] in [onCreate] anyways using [layoutResId].
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
    AppCompatActivity() {

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
    private lateinit var dataBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(getBindingVariable(), viewModel)
        dataBinding(dataBinding)
        setObservers()
        otherStuffs()
    }

    abstract fun setObservers()

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