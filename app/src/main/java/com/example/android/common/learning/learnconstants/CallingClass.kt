package com.example.android.common.learning.learnconstants

/**
 * 6/15/2020
 * Accessing java static like variables defined inside of a companion object.
 * @author srdpatel
 * @since 1.0
 */
fun main() {
    println(StaticInCompanionObjectClass.staticExample + StaticInCompanionObjectClass.jvmStaticExample)
}

class CallingClass {
    var refStaticExample = StaticInObjectDeclaration.staticExample
    var refJvmStaticExample = StaticInObjectDeclaration.jvmStaticExample
}