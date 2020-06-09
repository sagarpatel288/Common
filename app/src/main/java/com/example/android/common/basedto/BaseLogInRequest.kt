package com.example.android.common.basedto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * 4/13/2020
 *
 * <p>
 *
 * </p>
 *  {@link #} []
 *
 * @author srdpatel
 * @see <a href="https://android.jlelse.eu/demystifying-the-jvmoverloads-in-kotlin-10dd098e6f72">JvmOverloads</a>
 * [JvmOverloads] (https://android.jlelse.eu/demystifying-the-jvmoverloads-in-kotlin-10dd098e6f72 "JvmOverloads")
 * @since 1.0
 */
@Parcelize
data class BaseLogInRequest @JvmOverloads constructor(
    val email: String = "",
    val countryCode: String = "",
    val mobileNumber: String = "",
    val uniqueId: String = "",
    val password: String = ""
) : Parcelable