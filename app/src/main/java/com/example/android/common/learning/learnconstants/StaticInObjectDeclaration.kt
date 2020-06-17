package com.example.android.common.learning.learnconstants

/**
 * 6/15/2020
 * An example of java "static" like variable in kotlin
 * @author srdpatel
 * @since 1.0
 */
object StaticInObjectDeclaration {

    /**
     * 6/15/2020
     * By default, it is private and Unable to reach from Java!
     * Check below, 2nd example, [jvmStaticExample] to expose a field to Java caller.
     *
     * @author srdpatel
     * @since 1.0
     */
    var staticExample = "staticExample"

    /**
     * 6/15/2020
     * `@JvmField` to expose a field to Java callers. Available from Java!
     * Use `@JvmStatic` to expose a static method to Java callers.
     * @author srdpatel
     * @since 1.0
     */
    @JvmField
    var jvmStaticExample = "jvmStaticExample"

    /**
     * 6/15/2020
     * `@JvmField` to expose a field to Java callers. Available from Java!
     * Use `@JvmStatic` to expose a static method to Java callers.
     * @author srdpatel
     * @since 1.0
     */
    @JvmStatic
    fun jvmStaticMethod() = "jvmStaticMethod"

    fun staticMethod() = "staticMethod"
}