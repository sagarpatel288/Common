package com.example.android.common.learning.learnconstants

import com.example.android.common.learning.learnconstants.ValInObjectDeclaration.valInObjectDeclaration

/**
 * 6/16/2020
 * Accessing java `static` like members defined inside of an object declaration.
 * @author srdpatel
 * @since 1.0
 */
fun main() {
    /**
     * 6/19/2020
     * [valInObjectDeclaration] is defined inside of an object declaration as:
     * ```
     *  val valInObjectDeclaration = topLevelFun() //where topLevelFun() is a top-level function.
     * ```
     * In order to access [valInObjectDeclaration], we had to import the relevant file.
     * @author srdpatel
     * @since 1.0
     */
    println(valInObjectDeclaration)
}