package com.example.android.common.baseutils

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.example.android.common.baseconstants.PARCEL

class IntentUtils {
    companion object {

        @JvmStatic
        fun hasParcel(intent: Intent): Boolean {
            return intent.hasExtra(PARCEL)
        }

        @JvmStatic
        fun <T : Parcelable> getParcel(intent: Intent): T? {
            return if (hasParcel(intent)) intent.getParcelableExtra(PARCEL) else null
        }

        @JvmStatic
        fun <T : Parcelable> getIntentWithParcel(context: Context, t: T, className: Class<*>): Intent {
            val intent = Intent(context, className)
            intent.putExtra(PARCEL, t)
            return intent
        }
    }
}