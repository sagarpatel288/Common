package com.example.android.common.learning.learnconstants

/**
 * 6/23/2020
 * Examining access to a `public final` class for `var` from outside the class.
 *
 * @author srdpatel
 * @since 1.0
 */
fun main() {

    /**
     * 6/23/2020
     * An object of a [VarInClass] showing access to a `public final` class.
     *
     * @author srdpatel
     * @since 1.0
     */
    val varInClass = VarInClass()

    /**
     * 6/24/2020
     * "varInClassCompileTime" is defined in the "public final" kotlin class as:
     * ```
     * var varInClassCompileTime = "var in class for known value at compile time"
     * ```
     * prints: "var in class for known value at compile time"
     *
     * @since 1.0
     */
    println(varInClass.varInClassCompileTime)

    /**
     * 6/24/2020
     * We are accessing the kotlin "var" variable defined
     * in a kotlin "public final" class as:
     * ```
     * var varInClassRunTime = someFun()
     * ```
     * prints (unknown result of the function "someFun()"): runtime value from the function
     *
     * @since 1.0
     */
    println(varInClass.varInClassRunTime)

    /**
     * 6/24/2020
     * We are accessing the kotlin "var" variable defined
     * in a kotlin "public final" class as:
     * ```
     * @JvmField
     * var jvmFieldVarInClass = someFun()
     * ```
     * prints (unknown result of the function "someFun()"): runtime value from the function
     *
     * @since 1.0
     */
    println(varInClass.jvmFieldVarInClass)

    /*println(varInClass.varInClassPrivate)*/ //we cannot access "private" members

    /**
     * 6/24/2020
     * We are accessing the kotlin "public" function defined in a kotlin "public final" class as:
     * ```
     * fun publicFun() = "public fun"
     * ```
     * prints (unknown result of the function "publicFun()"): public fun
     *
     * @since 1.0
     */
    println(varInClass.publicFun())

    /*println(varInClass.someFun())*/ //We cannot access "private" functions.

}