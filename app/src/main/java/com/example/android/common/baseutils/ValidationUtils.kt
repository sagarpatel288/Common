package com.example.android.common.baseutils

import android.telephony.PhoneNumberUtils
import com.example.android.common.R
import com.example.android.common.basedto.ValidationDto
import com.example.android.common.basedto.ValueDto
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.regex.Pattern

class ValidationUtils {

    companion object : KoinComponent {

        // comment by srdpatel: 4/11/2020 Because many tests don't know about this android framework, we can mock it
        private val emailPattern: Pattern by inject()

        /**
         * 4/13/2020
         * Kotlin, with the help of default parameters and named arguments, helps us to reduce
         * the number of overloads that we generally need in Java world.
         * <p>
         * Call this function with named argument/s so that you can take advantage of kotlin default method overload behavior
         * <p>
         * If we need a way to find whether the value passed is mandatory or not, we can use [com.example.android.common.basedto.ValueDto]
         * that has a boolean field from which we can identify and process according to mandatory status of the given value.
         * </p>
         *  {@link #} []
         *
         * @author srdpatel
         * @see <a href="https://android.jlelse.eu/demystifying-the-jvmoverloads-in-kotlin-10dd098e6f72">JvmOverloads</a>
         * [JvmOverloads] (https://android.jlelse.eu/demystifying-the-jvmoverloads-in-kotlin-10dd098e6f72 "JvmOverloads")
         * @see <a href="https://www.geeksforgeeks.org/kotlin-default-and-named-argument/">Default and Named argument</a>
         * [Default and Named Argument] (https://www.geeksforgeeks.org/kotlin-default-and-named-argument/ "Default and named argument")
         * @since 1.0
         */
        @JvmStatic
        // comment by srdpatel: 4/13/2020 This method should return enum!
        fun validate(
            profilePhoto: ValueDto? = null,
            firstName: ValueDto? = null,
            lastName: ValueDto? = null,
            fullName: ValueDto? = null,
            email: ValueDto? = null,
            countryCode: ValueDto? = null,
            mobileNumber: ValueDto? = null,
            uniqueId: ValueDto? = null,
            address: ValueDto? = null,
            area: ValueDto? = null,
            district: ValueDto? = null,
            pincode: ValueDto? = null,
            state: ValueDto? = null,
            password: ValueDto? = null,
            confirmPassword: ValueDto? = null
        ): ValidationDto {
            if (profilePhoto?.isMandatory == true && profilePhoto.value.isNullOrEmpty()) {
                return ValidationDto(false, R.string.com_st_error_empty_photo)
            }
            if (firstName?.isMandatory == true && firstName.value.isNullOrEmpty()) {
                return ValidationDto(false, R.string.com_st_error_empty_first_name)
            }
            if (lastName?.isMandatory == true && lastName.value.isNullOrEmpty()) {
                return ValidationDto(false, R.string.com_st_error_empty_last_name)
            }
            if (fullName?.isMandatory == true && fullName.value.isNullOrEmpty()) {
                return ValidationDto(false, R.string.com_st_error_empty_name)
            }
            if (email?.isMandatory == true) {
                if (email.value.isNullOrEmpty()) {
                    return ValidationDto(false, R.string.com_st_error_empty_email)
                } else if (!isValidEmail(email.value)) {
                    return ValidationDto(false, R.string.com_st_error_invalid_email)
                }
            }
            if (countryCode?.isMandatory == true) {
                if (countryCode.value.isNullOrEmpty()) {
                    return ValidationDto(false, R.string.com_st_error_empty_country_code)
                }
            }
            return ValidationDto(false, -1, "")
        }

        @JvmStatic
        fun isValidEmail(email: String): Boolean {
            return email.isNotEmpty() && emailPattern.matcher(email).matches()
        }

        @JvmStatic
        fun isValidPhoneNumber(phoneNumberWithCountryCode: String): Boolean {
            // comment by srdpatel: 6/9/2020 Google country code validator
            return phoneNumberWithCountryCode.isNotEmpty() && PhoneNumberUtils.isGlobalPhoneNumber(phoneNumberWithCountryCode)
        }
    }
}