package com.example.android.common.basemodels

/**
 * 4/4/2020
 * This class considers common properties that every user object would have
 * <p>
 *
 * </p>
 *  {@link #} []
 *
 * @param
 * @return
 * @author srdpatel
 * @see <a href="http://google.com"></a>
 * [] (http://google.com "")
 * @since 1.0
 */
data class BaseUserInfo @JvmOverloads constructor(
    var userId: String = "",
    var loginId: String = "",
    var defaultName: String = "",
    var email: String = "",
    var mobile: String = "",
    var countryCode: String = "",
    var photo: String = ""
)