package com.example.android.common.learning.learnconstants

/**
 * 6/21/2020
 * Examining different ways of using `val` in an `object declaration`.
 *
 * @author srdpatel
 * @since 1.0
 */
object ValInObjectDeclaration {

    /**
     * 6/21/2020
     * <p>
     * Behind the scene:
     * <p>
     * The compiler will generate `private static final` variable and the
     * additional getter method (with `get` suffix and in camel-case) through which
     * java caller can access the variable.
     * <p>
     * How to access from kotlin:
     * <p>
     * In kotlin, we can access such a variable like a `public static final` variable
     * using proper import.
     * <p>
     * How to access from Java:
     * <p>
     * We cannot access such a variable from Java as the compiler makes it `private`.
     * <p>
     * Java equivalent:
     * <p>
     * The Java equivalent of `val` inside an `object declaration` is:
     * `private static final`.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    val valInObjectDeclaration = topLevelFun()

    /**
     * 6/21/2020
     * <p>
     * Behind the scene:
     * <p>
     * The compiler will generate `private static final` variable and the
     * additional getter method (with `get` suffix and in camel-case) through which
     * java caller can access the variable.
     * <p>
     * How to access from kotlin:
     * <p>
     * In kotlin, we can access such a variable like a `public static final` variable
     * using proper import.
     * <p>
     * How to access from Java:
     * <p>
     * We cannot access such a variable from Java as the compiler makes it `private`.
     * <p>
     * Java equivalent:
     * <p>
     * The Java equivalent of `val` inside an `object declaration` is:
     * `private static final`.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    const val constValInObjectDeclaration = "const val in object declaration"

    @JvmField
    val jvmFieldInObjectDeclaration = topLevelFun()
}