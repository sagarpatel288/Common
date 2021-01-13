package com.example.android.common.baseutils

fun main() {

}

class MathUtils {
    companion object {
        @JvmStatic
        fun percentageOf(percentage: Float, of: Float): Float {
            return (of * percentage) / 100
        }
    }
}