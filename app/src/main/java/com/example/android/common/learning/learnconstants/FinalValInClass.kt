package com.example.android.common.learning.learnconstants

/**
 * 6/18/2020
 * `val` is like `final` of Java.
 * We use `val` when the value of a final (read only) property is initialized at runtime.
 * That means, we can assign the value from a function or a constructor.
 * We can also use `val` when the value of a final property is known at compile time but for that case,
 * we should prefer to use `const val` (kind of `static final` in Java) instead of only `val` to avoid
 * runtime overhead of accessing the variable.
 *
 * @author srdpatel
 * @see <a href="http://google.com"></a>
 * @since 1.0
 */
val topLevelVal = "top-level val"

/**
 * 6/18/2020
 * `const val` is like `static final` of Java.
 * We use `const val` when the value of a read-only (final) property is known at compile time.
 * That means, we cannot assign the value from a function or a constructor.
 * So, `const val` is applicable to primitive data types and String only.
 * Also, `const val` is allowed only inside the `companion object`, `object declaration` or at top-level (outside the class).
 *
 * @author srdpatel
 * @see <a href="http://google.com"></a>
 * @since 1.0
 */
const val constValOutsideClass = "a const val outside the class at top-level"

/**
 * 6/16/2020
 * `@JvmField` to expose a field to Java callers without generating getter. Available from Java!
 *
 * @author srdpatel
 * @since 1.0
 */
@JvmField
val jvmFieldValOutsideClass = "jvmField val outside the class at top-level"

/**
 * 6/18/2020
 * Neither we can apply `@JvmStatic` annotation outside the `object declaration` or `companion object` nor we need.
 * All top-level functions can be accessed from Java.
 *
 * @author srdpatel
 * @since 1.0
 */
fun topLevelFun() = "top-level function"

class ValInClass {

    /*const val constValInClass = "const val in class is not allowed"*/

    /**
     * 6/18/2020
     * `val` is kind of `final` of Java.
     * We use `val` when the value of a final (read only) property is initialized at runtime.
     * That means, we can assign the value from a function or a constructor.
     * We can also use `val` when the value of a final property is known at compile time but for that case,
     * we should prefer to use `const val` (kind of `static final` in Java) instead of only `val` to avoid
     * runtime overhead of accessing the variable.
     *
     * @author srdpatel
     * @see <a href="http://google.com"></a>
     * @since 1.0
     */
    val valFinalExample = someFunction()

    /**
     * 6/16/2020
     * `@JvmField` to expose a field to Java callers. Available from Java!
     *
     * @author srdpatel
     * @since 1.0
     */
    @JvmField
    val jvmFieldFinalExample = someFunction()

    /**
     * 6/18/2020
     * A simple sample private function returning a string literal.
     *
     * @author srdpatel
     * @since 1.0
     */
    private fun someFunction() = "from the function"
}