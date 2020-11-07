package com.example.android.common.learning.learnconstants

class ValInCompanionObjectClass {

    companion object {

        val valInCompanionObject = topLevelFun()

        const val constValInCompanionObject = "const val in object declaration"

        @JvmField
        val jvmFieldInCompanionObject = topLevelFun()
    }
}