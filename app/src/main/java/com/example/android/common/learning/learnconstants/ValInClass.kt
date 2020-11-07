package com.example.android.common.learning.learnconstants

/**
 * 6/18/2020
 * <p>
 * `val` is like `final` of Java.
 * We use `val` for read-only (final) properties. They can be assigned only once.
 * We can assign runtime value (unknown value at compile time) like from a function.
 * We can also use `val` when the value of a final property is known at compile time but for that case,
 * we should prefer to use `const val` (kind of `static final` in Java) instead of only `val` to avoid
 * runtime overhead of accessing the variable.
 * <p>
 * This kind of top-level `val` without `@JvmField` annotation is accessible from Java through the
 * auto generated getter method (get prefix and in camel-case) and not directly.
 * </p>
 * @author srdpatel
 * @since 1.0
 */
val topLevelVal = topLevelFun()

/**
 * 6/18/2020
 * <p>
 * `const val` is like `static final` of Java.
 * We use `const val` when the value of a read-only (final) property is known at compile time.
 * That means, we cannot assign the value from a function or a constructor.
 * Similar to `val`; we cannot reassign the value for a `const val` variable.
 * `const val` is applicable to primitive data types and String only.
 * Also, `const val` is allowed only inside the `companion object`, `object declaration` or at top-level (outside the class).
 * <p>
 * This kind of top-level `const val` is accessible from Java with the help of
 * auto generated class name (with `Kt` suffix) as qualifier (like a `static` member access in Java).
 * </p>
 * @author srdpatel
 * @since 1.0
 */
const val constValOutsideClass = "a const val outside the class at top-level"

/**
 * 6/16/2020
 * <p>
 * We use `@JvmField` for top-level `val` if the value is not known at compile time and the value is coming from
 * a function. If the value for `val` is known at compile time and if the value is of primitive type or a String,
 * we can use `const` instead of `@JvmField`.
 * <p>
 * This kind of `val` with `@JvmField` annotation is accessible from Java with the help of
 * auto generated class name (with `Kt` suffix) as qualifier (like a `static` member access in Java).
 * </p>
 * @author srdpatel
 * @since 1.0
 */
@JvmField
val jvmFieldValOutsideClass = topLevelFun()

/**
 * 6/18/2020
 * Neither we can apply `@JvmStatic` annotation outside the `object declaration` or `companion object` nor we need.
 * All top-level functions can be accessed from Java with the help of
 * auto generated class name (with `Kt` suffix) as qualifier (like a `static` member access in Java).
 *
 * @author srdpatel
 * @since 1.0
 */
fun topLevelFun() = "top-level function"

class ValInClass {

    /*const val constValInClass = "const val in class is not allowed"*/

    /**
     * 6/18/2020
     * <p>
     * `val` is kind of `final` of Java.
     * We use `val` when the value of a final (read only) property is initialized at runtime.
     * That means, we can assign the value from a function or a constructor.
     * We can also use `val` when the value of a final property is known at compile time but for that case,
     * we should prefer to use `const val` (kind of `static final` in Java) instead of only `val` to avoid
     * runtime overhead of accessing the variable.
     * <p>
     * This kind of variable (`val` inside a class) is not accessible from Java.
     * Only top-level or members of object declaration and companion object with proper annotation are accessible
     * from Java.
     * </p>
     * @author srdpatel
     * @see <a href="http://google.com"></a>
     * @since 1.0
     */
    val valFinalExample = someFunction()

    /**
     * 6/16/2020
     * <p>
     * `@JvmField` to expose a field to Java callers. Available from Java!
     * <p>
     * This kind of variable (`val` inside a class) is not accessible from Java.
     * Only top-level or members of object declaration and companion object with proper annotation are accessible
     * from Java.
     * </p>
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