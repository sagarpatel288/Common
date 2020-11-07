package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;

public final class GeneratedFinalValInClassKt {

    /**
     * 6/19/2020
     * This is kotlin bytecode equivalent for the variable defined at top-level as below:
     * <p>
     * ```
     * {@code const val constValOutsideClass = "a const val outside the class at top-level"}
     * ```
     * <p>
     * We can see here that the kotlin bytecode has made it {@code public static final}.
     *
     * </p>
     *
     * @since 1.0
     */
    @NotNull
    public static final String constValOutsideClass = "a const val outside the class at top-level";

    /**
     * 6/19/2020
     * This is kotlin bytecode equivalent for the variable defined at top-level as below:
     * <p>
     * ```
     * {@code @JvmField val jvmFieldValOutsideClass = "jvmField val outside the class at top-level"}
     * ```
     * <p>
     * We can see here that the kotlin bytecode has made it {@code public static final}.
     * </p>
     *
     * @since 1.0
     */
    @JvmField
    @NotNull
    public static final String jvmFieldValOutsideClass = topLevelFun();

    @NotNull
    private static final String topLevelVal = "top-level val";

    @NotNull
    public static final String getTopLevelVal() {
        return topLevelVal;
    }

    @NotNull
    public static final String topLevelFun() {
        return "top-level function";
    }
}

