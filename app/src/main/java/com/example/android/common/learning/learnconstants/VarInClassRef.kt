package com.example.android.common.learning.learnconstants

/**
 * 6/21/2020
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
var varOutOfClassAtTopLevel = "var out of class at top-level"

/**
 * 6/21/2020
 * Examining `var` and its variants inside class and at top-level
 *
 * @author srdpatel
 * @since 1.0
 */
class VarInClassRef {

    var varInClass = someFunction()

    private val varInClassObject = VarInClass()

    fun accessPublicVar() {
        varInClassObject.jvmFieldVarInClass
    }

    @JvmField
    var jvmVarField = "jvmVarField ${someFunction()}"

    private fun someFunction() = "from the function"
}