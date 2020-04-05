package com.example.android.common.basemodels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseResponse<T : Parcelable>(
    var status: String = "",
    var message: String = "",
    var data: T?
) : Parcelable