package com.example.android.common.basedto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleResponse(
    var status: String = "",
    var message: String = "",
    val id: Int,
    var isPositive: Boolean = false, //success or fail
    var data: Parcelable //
) : Parcelable