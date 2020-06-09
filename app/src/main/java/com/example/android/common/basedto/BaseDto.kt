package com.example.android.common.basedto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// comment by srdpatel: 4/3/2020 Need to check if given default values are working or not
@Parcelize
data class BaseDto (var isSelected: Boolean = true, var isClickable: Boolean = true) : Parcelable