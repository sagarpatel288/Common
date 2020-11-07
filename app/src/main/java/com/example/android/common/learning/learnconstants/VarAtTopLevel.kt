package com.example.android.common.learning.learnconstants

/**
 * 6/22/2020
 * Assigns a compile time value to the top-level variable: [varTopLevelCompileTime]
 * <p>
 * `var` is used to assign the runtime or compile time value to the variable that can be reassigned.
 * <p>
 * Behind the scene of top-level `var`:
 * <p>
 * The compiler will generate a `public final` class with `Kt` suffix
 * for the top-level members.
 * <p>
 * The compiler will generate a `private static` variable for the
 * top-level `var` variable defined in kotlin and two additional
 * `public static final` getter-setter methods.
 * <p>
 * How to access from kotlin:
 * <p>
 * In kotlin, we can access such a variable like a `public static` variable.
 * <p>
 * How to access from Java:
 * <p>
 * We can access such a variable from Java using the relevant auto generated `getter` method.
 * (function with `get` prefix).
 * <p>
 * Java equivalent of top-level `var`:
 * <p>
 * The Java equivalent of `var` at top-level is:
 * `private static` with `public` getter-setter methods.
 * <p>
 * Consider:
 * <p>
 * Two additional public getter-setter methods.
 * </p>
 *
 * @author srdpatel
 * @since 1.0
 */
var varTopLevelCompileTime = "var out of class at top-level"

/**
 * 6/22/2020
 * Assigns a runtime value to the top-level variable: [varTopLevelRunTime]
 * All the top-level `public` members in kotlin are like java `public static` members
 * and can be accessed by directly their names.
 *
 * @author srdpatel
 * @since 1.0
 */
var varTopLevelRunTime = topLevelFunction()

/**
 * 6/24/2020
 * Assigns a runtime value to the top-level variable: [varTopLevelPrivate]
 * All the top-level `private` members in kotlin are like java `private static` members
 * and can be accessed within the containing file only.
 *
 * @author srdpatel
 * @since 1.0
 */
private var varTopLevelPrivate = topLevelPrivateFunction()

/**
 * 6/24/2020
 * Assigns a runtime value to the top-level variable: [jvmFieldVarTopLevel]
 * <p>
 * Kotlin bytecode:
 * <p>
 * `@JvmField` is used to expose the member in Java. 
 * It makes the member `public` without auto generating any additional method as below:
 * ```
 *  @JvmField
 *  @NotNull
 *  public static String jvmFieldVarTopLevel = topLevelFunction();
 * ```
 * </p>
 *
 * @author srdpatel
 * @since 1.0
 */
@JvmField
var jvmFieldVarTopLevel = topLevelFunction()

/**
 * 6/22/2020
 * Neither we can apply `@JvmStatic` annotation outside the `object declaration` or `companion object` nor we need.
 * All top-level functions can be accessed from Java with the help of
 * auto generated class name (with `Kt` suffix) as qualifier (like a `static` member access in Java).
 * In kotlin, we can access it like a java `public static final` method.
 *
 * @author srdpatel
 * @since 1.0
 */
fun topLevelFunction() = "from the top-level function"

private fun topLevelPrivateFunction() = "from the top-level private function"

/**
 * 6/22/2020
 * Examines top-level `var` variables.
 *
 * @author srdpatel
 * @since 1.0
 */
class VarAtTopLevel {
}