package com.example.android.common.baseutils

class StringUtils {
    companion object{

        @JvmStatic
        fun isNullOrEmpty(string: String?): Boolean{
            return string.isNullOrEmpty() || string.equals("null", ignoreCase = true)
        }
    }
}