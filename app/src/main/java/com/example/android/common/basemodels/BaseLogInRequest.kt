package com.example.android.common.basemodels

data class BaseLogInRequest @JvmOverloads constructor(
    val email: String = "",
    val countryCode: String = "",
    val mobileNumber: String = "",
    val uniqueId: String = "",
    val password: String = ""
)