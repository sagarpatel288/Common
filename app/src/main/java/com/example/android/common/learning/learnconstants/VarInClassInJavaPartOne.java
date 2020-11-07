package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

/**
 * 6/22/2020
 * Unlike kotlin, we have to write {@code public} keyword in Java.
 * In kotlin, classes are {@code public} by default. We don't have to write.
 * Unlike kotlin, we have to write {@code final} keyword in Java to save the class from inheritance.
 * In kotlin, classes are {@code final} by default. They can't be inherited unless we mark it as {@code open}.
 *
 * @author srdpatel
 * @see <a href="https://kotlinlang.org/docs/reference/classes.html">Classes and Inheritance</a>
 * @see <a href="https://kotlinlang.org/docs/reference/visibility-modifiers.html">Visibility modifiers</a>
 * @since 1.0
 */
public final class VarInClassInJavaPartOne {

    /**
     * 6/22/2020
     * It is defined in a kotlin class as:
     * <p>
     * {@code
     * var varInClassCompileTime = "var in class for known value at compile time"
     * }
     * <p>
     * The kotlin compiler treats it like a java {@code private} member as below.
     * </p>
     *
     * @since 1.0
     */
    @NotNull
    private String varInClassCompileTime = "var in class for known value at compile time";

    /**
     * 6/22/2020
     * It is defined in a kotlin class as:
     * <p>
     * {@code
     * var varInClassRunTime = someFun()
     * }
     * <p>
     * The kotlin compiler treats it like a java {@code private} member as below.
     * </p>
     *
     * @since 1.0
     */
    @NotNull
    private String varInClassRunTime = this.someFun();

    /**
     * 6/22/2020
     * This is auto generated getter method for the kotlin variable defined in a class as:
     * <p>
     * {@code
     * var varInClassCompileTime = "var in class for known value at compile time"
     * }
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    @NotNull
    public final String getVarInClassCompileTime() {
        return this.varInClassCompileTime;
    }

    /**
     * 6/22/2020
     * This is auto generated setter method for the kotlin variable defined in a class as:
     * <p>
     * {@code
     * var varInClassCompileTime = "var in class for known value at compile time"
     * }
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    public final void setVarInClassCompileTime(@NotNull String var1) {
        /*...*/
        this.varInClassCompileTime = var1;
    }

    /**
     * 6/22/2020
     * This is auto generated getter method for the kotlin variable defined in a class as:
     * <p>
     * {@code
     * var varInClassRunTime = someFun()
     * }
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    @NotNull
    public final String getVarInClassRunTime() {
        return this.varInClassRunTime;
    }

    /**
     * 6/22/2020
     * This is auto generated setter method for the kotlin variable defined in a class as:
     * <p>
     * {@code
     * var varInClassRunTime = someFun()
     * }
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    public final void setVarInClassRunTime(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.varInClassRunTime = var1;
    }

    /**
     * 6/22/2020
     * <p>
     * This is a simple method defined in a kotlin class to show how we can
     * access and reassign the {@code var} variable in a function and how we can
     * define a local {@code var} variable in a function.
     * <p>
     * All the functions in kotlin are by default: {@code final}
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    private final void changeVarValue() {
        this.varInClassCompileTime = "accessing and reassigning var value in a member function for " + this.varInClassCompileTime;
        this.varInClassRunTime = "accessing and reassigning var value in a member function for " + this.varInClassRunTime;
        String localVarInFunction = "local var in a function";
    }

    /**
     * 6/22/2020
     * <p>
     * It is defined in a kotlin class to show how we can assign the runtime value
     * to a variable using {@code var}.
     * <p>
     * All the functions in kotlin are by default: {@code final}
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    private final String someFun() {
        return "runtime value from the function";
    }
}
