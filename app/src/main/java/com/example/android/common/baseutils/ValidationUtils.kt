package com.example.android.common.baseutils

import com.example.android.common.basestate.StateLogInSignUpForm

class ValidationUtils {
    companion object {

        /**
         * 4/13/2020
         * Kotlin, with the help of default parameters and named arguments helps us to reduce
         * the number of overloads that we generally need in Java world.
         * <p>
         * Call this function with named argument/s so that you can take advantage of kotlin default method overload behavior
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
            email: String = "",
            countryCode: String = "",
            mobileNumber: String = "",
            uniqueId: String = "",
            password: String = "",
            confirmPassword: String = ""
        ): StateLogInSignUpForm {
            return StateLogInSignUpForm.False
        }
    }
}