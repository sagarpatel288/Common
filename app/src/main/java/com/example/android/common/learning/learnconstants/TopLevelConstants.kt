package com.example.android.common.learning.learnconstants

import com.example.android.common.basedto.BaseDto

/**
 * 6/15/2020
 * ```const``` keyword is allowed only on top level package file like this
 * or as a member in ```object``` declaration and ```companion object```.
 * ```const``` keyword is not applicable inside a class.
 * @author srdpatel
 * @since 1.0
 */
const val CONSTANT = "only primitive and String are allowed for const val"
@JvmField val NONPRIMITIVE = BaseDto()
