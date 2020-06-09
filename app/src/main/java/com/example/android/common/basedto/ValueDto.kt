package com.example.android.common.basedto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// comment by srdpatel: 4/3/2020 Need to check if given default values are working or not
@Parcelize
data class ValueDto (var isMandatory: Boolean? = false, val value: String? = "", var id: Int? = -1) : Parcelable