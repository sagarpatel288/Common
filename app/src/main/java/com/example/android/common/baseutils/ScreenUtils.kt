package com.example.android.common.baseutils

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import com.example.android.common.baseconstants.StaticConstants

fun main() {

}

class ScreenUtils {

    companion object {

        /**
         * 1/4/2021 17:43
         * Sets global constants for screen height and screen width
         *
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun getScreenSize(context: Context): MutableList<Int> {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val display = context.display
                display?.getRealMetrics(displayMetrics)
            } else {
                @Suppress("DEPRECATION")
                val display = windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(displayMetrics)
            }

            val displayMetricsHeightPixels = displayMetrics.heightPixels
            val displayMetricsWidthPixels = displayMetrics.widthPixels

            Log.d(
                " :BaseActivity: ",
                "getScreenSize: displayMetrics.heightPixels: $displayMetricsHeightPixels"
            )
            Log.d(
                " :BaseActivity: ",
                "getScreenSize: displayMetrics.widthPixels: $displayMetricsWidthPixels"
            )

            val size = Point()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                context.display?.getRealSize(size)
            } else {
                @Suppress("DEPRECATION")
                context.display?.getSize(size)
            }

            val screenWidth: Int = size.x
            val screenHeight: Int = size.y

            Log.d(
                " :BaseActivity: ",
                "getScreenSize: displayMetrics.heightPixels: $screenWidth"
            )
            Log.d(
                " :BaseActivity: ",
                "getScreenSize: displayMetrics.widthPixels: $screenHeight"
            )

            StaticConstants.screenHeight = screenHeight
            StaticConstants.screenWidth = screenWidth

            /*if (hasNavigationBar(Resources.getSystem())) {
            StaticConstants.screenHeight = displayMetrics.heightPixels + getNavigationBarHeight()
        }*/

            return mutableListOf<Int>(StaticConstants.screenHeight, StaticConstants.screenWidth)
        }

        @JvmStatic
        fun hasNavigationBar(resources: Resources): Boolean {
            val id: Int = resources.getIdentifier("config_showNavigationBar", "bool", "android")
            return id > 0 && resources.getBoolean(id)
        }

        @JvmStatic
        fun getNavigationBarHeight(context: Context): Int {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                val displayMetrics = DisplayMetrics()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val display = context.display
                    display?.getRealMetrics(displayMetrics)
                } else {
                    @Suppress("DEPRECATION")
                    val display = windowManager.defaultDisplay
                    @Suppress("DEPRECATION")
                    display.getMetrics(displayMetrics)
                }

                val usableHeight = displayMetrics.heightPixels

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val display = context.display
                    display?.getRealMetrics(displayMetrics)
                } else {
                    @Suppress("DEPRECATION")
                    val display = windowManager.defaultDisplay
                    @Suppress("DEPRECATION")
                    display.getMetrics(displayMetrics)
                }

                val realHeight = displayMetrics.heightPixels
                return if (realHeight > usableHeight) realHeight - usableHeight else 0
            }
            return 0
        }
    }
}