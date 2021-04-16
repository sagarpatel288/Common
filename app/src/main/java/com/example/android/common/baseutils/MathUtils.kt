package com.example.android.common.baseutils

import android.content.Context
import android.util.TypedValue

fun main() {

}

class MathUtils {
    companion object {
        @JvmStatic
        fun percentageOf(percentage: Float, of: Float): Float {
            return (of * percentage) / 100
        }

        // Extension method to convert pixels to dp
        @JvmStatic
        fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
        ).toInt()

        @JvmStatic
        fun IntToDp(context: Context, int: Int): Int = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, int.toFloat(), context.resources.displayMetrics
        ).toInt()
    }
}