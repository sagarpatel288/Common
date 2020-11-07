package com.example.android.common.learning.learnconstants


/**
 * 6/19/2020
 * <p>
 * We use `var` for mutable property that can be re-assigned.
 * <p>
 * Top-level `var` is
 * </p>
 * @author srdpatel
 * @since 1.0
 */
var varOutsideClass = "var outside the class, at top-level. Runtime value is allowed."

/**
 * 6/19/2020
 * `@JvmField var` {@link #} []
 *  []
 * @author srdpatel
 * @see <a href="http://google.com"></a>
 * @since 1.0
 */
@JvmField
var jvmVarOutsideClass = "jvmField var outside the class at top-level. Runtime value is allowed."

/**
 * 6/16/2020
 * `companion object` works like a `static` access of java.
 * It is an `object declaration` inside a class.
 * Note that the `const` keyword is applicable to primitive data types and String only.
 * And We use `@JvmField` annotation for other (non-primitive) data types.
 * @author srdpatel
 * @since 1.0
 */
class StaticInCompanionObjectClass {

    /**
     * 6/16/2020
     * An example of java `static` like variable in kotlin.
     * Only one `companion object` is allowed per class.
     * We can omit the name of the `companion object` [StaticInCompanionObject] in which case
     * the name `Companion` will be used to access the members like:
     * ```
     * StaticInCompanionObjectClass.Companion
     * ```
     * [Reference](https://kotlinlang.org/docs/reference/object-declarations.html?q=&p=0)
     * @author srdpatel
     * @since 1.0
     */
    companion object StaticInCompanionObject {

        /**
         * 6/16/2020
         * By default, it is private and Unable to reach from Java!
         * Check below, 2nd example, [jvmStaticExample] to expose a field to Java caller.
         *
         * @author srdpatel
         * @since 1.0
         */
        var staticExample = "staticExample"

        /**
         * 6/16/2020
         * `@JvmField` to expose a field to Java callers. Available from Java!
         * Use `@JvmStatic` to expose a static method to Java callers.
         *
         * @author srdpatel
         * @since 1.0
         */
        @JvmField
        var jvmStaticExample = "jvmStaticExample"

        /**
         * 6/16/2020
         * Using `@JvmStatic` to expose a static method to Java callers.
         *
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        fun jvmStaticMethod() = "jvmStaticMethod"

        /**
         * 6/16/2020
         * This method will not be available to java callers as it lacks `@JvmStatic` annotation.
         *
         * @author srdpatel
         * @since 1.0
         */
        fun staticMethod() = "staticMethod"
    }
}