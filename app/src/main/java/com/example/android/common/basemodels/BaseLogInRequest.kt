package com.example.android.common.basemodels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BaseLogInRequest @JvmOverloads constructor(
    val email: String = "",
    val countryCode: String = "",
    val mobileNumber: String = "",
    val uniqueId: String = "",
    val password: String = ""
) : Parcelable