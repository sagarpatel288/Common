package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;

class FinalValInClassJava {

    /**
     * 6/19/2020
     * This is kotlin bytecode equivalent of the variable defined inside of a kotlin class as below:
     * ```
     * {@code @JvmField val jvmFieldFinalExample = someFunction()}
     * ```
     * We can see that the kotlin bytecode has made it public due to {@code JvmField} annotation.
     *
     * @since 1.0
     */
    @JvmField
    @NotNull
    public final String jvmFieldFinalExample = this.someFunction();

    /**
     * 6/19/2020
     * This is kotlin bytecode equivalent of the variable defined inside of a kotlin class as below:
     * <p>
     * ```
     * {@code val valFinalExample = someFunction()}
     * ```
     * <p>
     * We can see that the kotlin bytecode has made it private as it lacks {@code JvmField} annotation
     * and has created a {@code public getter} method {@link FinalValInClassJava#getValFinalExample()} to access it.
     * </p>
     *
     * @since 1.0
     */
    @NotNull
    private final String valFinalExample = this.someFunction();

    /**
     * 6/19/2020
     * This is kotlin bytecode addition for the variable defined inside of a kotlin class as below:
     * <p>
     * ```
     * {@code val valFinalExample = someFunction()}
     * ```
     * <p>
     * We can see here {@link FinalValInClassJava#valFinalExample} that the kotlin bytecode
     * has made it private as it lacks {@code JvmField} annotation and has created
     * this {@code public getter} method to access it.
     * </p>
     *
     * @since 1.0
     */
    @NotNull
    public final String getValFinalExample() {
        return this.valFinalExample;
    }

    /**
     * 6/19/2020
     * This is kotlin bytecode equivalent for the function defined inside of a kotlin class as below:
     * <p>
     * ```
     * {@code private fun someFunction() = "from the function"}
     * ```
     * <p>
     * We can see here that the kotlin bytecode has made it {@code final}.
     * Unlike java, all functions and classes are {@code final} by default in kotlin.
     * </p>
     *
     * @since 1.0
     */
    private final String someFunction() {
        return "from the function";
    }

}
