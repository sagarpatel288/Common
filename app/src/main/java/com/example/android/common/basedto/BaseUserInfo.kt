package com.example.android.common.basedto

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
 * @see <a href="https://android.jlelse.eu/demystifying-the-jvmoverloads-in-kotlin-10dd098e6f72">JvmOverloads</a>
 * [JvmOverloads] (https://android.jlelse.eu/demystifying-the-jvmoverloads-in-kotlin-10dd098e6f72 "JvmOverloads")
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
) {
    fun BaseUserInfo.extensionFun(name: String) {
        println(name)
    }
}