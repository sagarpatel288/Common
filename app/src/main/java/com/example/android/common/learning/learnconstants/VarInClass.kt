package com.example.android.common.learning.learnconstants


/**
 * 6/22/2020
 * <p>
 * A java `public final` like class examining `var` variants.
 * In kotlin, all classes are by default like java `public final`.
 * They can't be inherited unless we mark it as `open`.
 * <p>
 * Being a `public` class, all the `public` members of this class are accessible from anywhere.
 * <p>
 * Introduction of `var`:
 * <p>
 * Variables that can be reassigned use the `var` keyword.
 * <p>
 * Value and Data Type Support:
 * <p>
 * We can use `var` to assign a runtime or compile time value.
 * We can use `var` for primitive, String and non-primitive data types.
 * <p>
 * Scope:
 * <p>
 * We can use `var` inside a class, a function, a constructor, an object declaration, a companion object and at top-level.
 * </p>
 * @author srdpatel
 * @since 1.0
 */
class VarInClass {

    /**
     * 6/22/2020
     * <p>
     * `var` is used for a variable [varInClassCompileTime] to
     * assign a known value at compile time.
     * <p>
     * Kotlin visibility and access:
     * <p>
     * It has default visibility: `public`.
     * So, all the class members can access this variable. No direct (`static` like) access from outside of this class.
     * Accessible by any object that can access the class. An object of this class can access this variable.
     * <p>
     * Java visibility and access (Java interop):
     * <p>
     * `var` without any prefix, annotation in a class is like a java `private` member.
     * Hence, a java caller cannot access this variable directly.
     * <p>
     * Kotlin Bytecode (Consider as a conclusion):
     * <p>
     * The compiler treats such a variable like a java `private` variable and
     * generates two additional `public final` getter-setter methods for such a variable.
     * The kotlin bytecode version would look like below:
     * ```
     * private String varInClassCompileTime = "var in class for known value at compile time";
     *
     * @NotNull
     * public final String getVarInClassCompileTime() {
     * return this.varInClassCompileTime;
     * }
     *
     * public final void setVarInClassCompileTime(@NotNull String var1) {
     * /*...*/
     * this.varInClassCompileTime = var1;
     * }
     * ```
     * <p>
     * Use:
     * <p>
     * In kotlin, as a global class member that can be reassigned and accessed from outside of this class
     * by the object of this class or to be used as a local variable in a function.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    var varInClassCompileTime = "var in class for known value at compile time"

    /**
     * 6/22/2020
     * `var` is used for variable [varInClassRunTime] to
     * assign an unknown value at runtime from the function.
     * <p>
     * Kotlin visibility and access:
     * <p>
     * All the class members can access this variable.
     * The object of this class is required in order to access this variable from outside of this class.
     * <p>
     * Java visibility and access (Java interop):
     * <p>
     * Like a java `private` member with `public` getter-setter methods.
     * <p>
     * Kotlin Bytecode (Consider as a conclusion):
     * <p>
     * Two additional `public final` getter-setter methods.
     * <p>
     * Use:
     * <p>
     * In kotlin, as a global class member that can be reassigned and accessed from outside of this class
     * by the object of this class or to be used as a local variable in a function.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    var varInClassRunTime = someFun()

    /**
     * 6/24/2020
     * `var` is used for variable [varInClassPrivate] to
     * assign an unknown value at runtime from the function.
     * <p>
     * Kotlin visibility and access:
     * <p>
     * All the class members can access this variable.
     * No one can access this variable from outside of this class.
     * <p>
     * Java visibility and access (Java interop):
     * <p>
     * Like a java `private` member without any getter-setter method.
     * <p>
     * Kotlin Bytecode (Consider as a conclusion):
     * <p>
     * A private variable with no additional `public final` getter-setter methods.
     * <p>
     * Use:
     * <p>
     * In kotlin, as a global class member that can be reassigned.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    private var varInClassPrivate = someFun()

    /**
     * 6/22/2020
     * <p>
     * We use `@JvmField` annotation when we want to expose a kotlin property as a field in java.
     * <p>
     * Kotlin visibility and access:
     * <p>
     * All the class members can access this variable.
     * An object of this class is required to access this variable from outside of this class.
     * <p>
     * Java visibility and access (Java interop):
     * <p>
     * An object of this class can access from Java.
     * <p>
     * Kotlin Bytecode (Consider as conclusion):
     * <p>
     * A java like `public` variable with no additional getter-setter methods.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    @JvmField
    var jvmFieldVarInClass = someFun()

    /*@JvmField
    private var jvmFieldPrivate = "@JvmField on private member has no effect"*/

    /**
     * 6/22/2020
     * Showing access and reassignment of a `var` in a function.
     * Also showing, `var` as a local variable in a function.
     *
     * @author srdpatel
     * @since 1.0
     */
    private fun changeVarValue() {

        //region Accessing and reassigning `var`
        varInClassCompileTime =
            "accessing and reassigning var value in a member function for $varInClassCompileTime"
        varInClassRunTime =
            "accessing and reassigning var value in a member function for $varInClassRunTime"
        //endregion

        /*
        * `var` for local variable that can be reassigned.
        * */
        var localVarInFunction = "local var in a function"
    }

    /**
     * 6/22/2020
     * A simple class member function (`private`) returning a hard coded [String] literal.
     *
     * @author srdpatel
     * @since 1.0
     */
    private fun someFun() = "runtime value from the function"

    /**
     * 6/24/2020
     * A simple class member function (`public`) returning a hard coded [String] literal.
     *
     * @author srdpatel
     * @since 1.0
     */
    fun publicFun() = "public fun"
}