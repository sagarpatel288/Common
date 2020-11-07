package com.example.android.common.learning.learnconstants

/**
 * 6/16/2020
 * Accessing java static like members defined inside of an object declaration and a companion object.
 * @author srdpatel
 * @since 1.0
 */
fun main() {

    //region Accessing `var` defined inside a class
    val varInClass = VarInClass()
    println(varInClass.varInClassCompileTime)
    println(varInClass.varInClassRunTime)
    println(varInClass.jvmFieldVarInClass)
    println(varInClass.publicFun())
    //endregion

    //region Accessing top-level members

    println(varOutsideClass)
    println(jvmVarOutsideClass)

    /**
     * 6/19/2020
     * [topLevelVal] is defined at top-level as:
     * ```
     * val topLevelVal = "top-level val"
     * ```
     *
     * @author srdpatel
     * @since 1.0
     */
    println(topLevelVal)

    /**
     * 6/19/2020
     * [constValOutsideClass] is defined at top-level as:
     * ```
     * const val constValOutsideClass = "a const val outside the class at top-level"
     * ```
     * @author srdpatel
     * @since 1.0
     */
    println(constValOutsideClass)

    /**
     * 6/19/2020
     * [jvmFieldValOutsideClass] is defined at top-level as:
     * ```
     * @JvmField
     * val jvmFieldValOutsideClass = "jvmField val outside the class at top-level"
     * ```
     * @author srdpatel
     * @since 1.0
     */
    println(jvmFieldValOutsideClass)

    /**
     * 6/19/2020
     * [topLevelFun] is defined at top-level as:
     * ```
     * fun topLevelFun() = "top-level function"
     * ```
     * @author srdpatel
     * @since 1.0
     */
    println(topLevelFun())
    //endregion

    //region Accessing members of a companion object
    println(StaticInCompanionObjectClass.staticExample + " " + StaticInCompanionObjectClass.jvmStaticExample)
    println(StaticInCompanionObjectClass.staticMethod() + " " + StaticInCompanionObjectClass.jvmStaticMethod())
    //endregion

    //region Accessing members of an object declaration
    println(StaticInObjectDeclaration.staticExample + " " + StaticInObjectDeclaration.jvmStaticExample)
    println(StaticInObjectDeclaration.staticMethod() + " " + StaticInObjectDeclaration.jvmStaticMethod())
    //endregion
}