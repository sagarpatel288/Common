package com.example.android.common.baseutils

import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import android.util.Log
import java.util.*


class GeoInfoUtils {

    companion object {

        const val TAG: String = "PhoneUtils"

        /**
         * 6/10/2020
         * [Reference](https://stackoverflow.com/questions/11293642/how-can-i-get-my-android-device-country-code-without-using-gps)
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun getCountryIsoCode(context: Context, defaultCountryIsoCode: String): String {
            getSimCountryIsoCode(context)?.let {
                return it
            }

            getNetworkCountryIsoCode(context)?.let {
                return it
            }

            getLocaleCountryIsoCode(context)?.let {
                return it
            }

            return defaultCountryIsoCode
        }

        /**
         * 6/10/2020
         * [TimeZone.getID] looks like Asia/Calcutta
         * We can get country from the [TimeZone.getID]
         * [Reference]()
         * @author srdpatel
         * @since 1.0
         */
        fun getTimeZoneId(): String {
            return TimeZone.getDefault().id
        }

        /**
         * 6/10/2020
         * [Reference](https://stackoverflow.com/questions/11293642/how-can-i-get-my-android-device-country-code-without-using-gps)
         * <p>
         * If i have a sim of the India, this method will give the iso code "IN" even if I am in Sri lanka.
         * </p>
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun getSimCountryIsoCode(context: Context): String? {
            try {
                val telephonyManager =
                    context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                Log.d(TAG, "getSimCountryIsoCode: ${telephonyManager.simCountryIso}")
                return telephonyManager.simCountryIso
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * 6/10/2020
         * [Reference](https://stackoverflow.com/questions/11293642/how-can-i-get-my-android-device-country-code-without-using-gps)
         * <p>
         * Even if i have a sim of the India, this method will give the iso code "US"
         * if I am in America or connected to an american network.
         * </p>
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun getNetworkCountryIsoCode(context: Context): String? {
            try {
                val telephonyManager =
                    context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                Log.d(TAG, "getNetworkCountryIsoCode: ${telephonyManager.simCountryIso}")
                return telephonyManager.networkCountryIso
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * 6/10/2020
         * [Reference](https://stackoverflow.com/questions/11293642/how-can-i-get-my-android-device-country-code-without-using-gps)
         * <p>
         * Irrespective of the sim I have or my location, this method gives iso code based on my device language configuration.
         * For example, this method will give "US" for most Indian android phones due to "English(US)" language set up.
         * </p>
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun getLocaleCountryIsoCode(context: Context): String? {
            try {
                val localeCountryISO = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    context.resources.configuration.locales[0].country
                } else {
                    context.resources.configuration.locale.country
                }
                Log.d(TAG, "getLocaleCountryIsoCode: $localeCountryISO")
                return localeCountryISO
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }
    }
}