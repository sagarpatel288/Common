package com.example.android.common.basedto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class BaseResponse(
    var status: String = "",
    var message: String = "",
    val id: Int,
    var isPositive: Boolean = false,
    var data: @RawValue Any? //obviously, this is not going to be parcelized on its own... we have to do it manually!
) : Parcelable