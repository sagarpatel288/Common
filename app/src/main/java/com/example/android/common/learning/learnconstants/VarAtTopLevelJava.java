package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

/**
 * 6/22/2020
 * <p>
 * Kotlin Bytecode generated and Java equivalent class
 * for a kotlin {@link VarAtTopLevel} class.
 * <p>
 * The compiler will generate a {@code public final} class with {@code Kt} suffix
 * for the top-level members.
 * <p>
 * The compiler will generate a {@code private static} variable for the
 * top-level {@code var} variable defined in kotlin and two additional
 * {@code public static final} getter-setter methods.
 *
 * </p>
 *
 * @author srdpatel
 * @since 1.0
 */
public final class VarAtTopLevelJava {

    @NotNull
    private static String varTopLevelCompileTime = "var out of class at top-level";

    @NotNull
    private static String varTopLevelRunTime = topLevelFunction();

    @NotNull
    public static final String getVarTopLevelCompileTime() {
        return varTopLevelCompileTime;
    }

    public static final void setVarTopLevelCompileTime(@NotNull String var0) {
        Intrinsics.checkParameterIsNotNull(var0, "<set-?>");
        varTopLevelCompileTime = var0;
    }

    @NotNull
    public static final String getVarTopLevelRunTime() {
        return varTopLevelRunTime;
    }

    public static final void setVarTopLevelRunTime(@NotNull String var0) {
        Intrinsics.checkParameterIsNotNull(var0, "<set-?>");
        varTopLevelRunTime = var0;
    }

    @NotNull
    public static final String topLevelFunction() {
        return "from the top-level function";
    }
}
