package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/**
 * 6/16/2020
 * Java equivalent class of {@link StaticInObjectDeclaration}
 *
 * @author srdpatel
 * since 1.0
 */
public final class StaticInObjectDeclarationJava {

    /**
     * 6/16/2020
     * singleton instance
     *
     * @author srdpatel
     * @since 1.0
     */
    public static final StaticInObjectDeclarationJava INSTANCE; //singleton instance

    /**
     * 6/16/2020
     * Note the {@code public} visibility modifier.
     *
     * @author srdpatel
     * @since 1.0
     */
    @JvmField
    @NotNull
    public static String jvmStaticExample;

    /**
     * 6/16/2020
     * Note the {@code private} visibility modifier.
     *
     * @author srdpatel
     * @since 1.0
     */
    @NotNull
    private static String staticExample;

    /*
     * 6/16/2020
     * Code inside static block is executed only once, when the class is loaded into memory for the first time.
     * Also, static block is executed before constructor (but, only once).
     * Reference "https://www.geeksforgeeks.org/g-fact-79/"
     *
     * @author srdpatel
     * @since 1.0
     */
    static {
        StaticInObjectDeclarationJava var0 = new StaticInObjectDeclarationJava();
        INSTANCE = var0;
        staticExample = "staticExample";
        jvmStaticExample = "jvmStaticExample";
    }


    /**
     * 6/16/2020
     * private constructor for singleton pattern
     *
     * @author srdpatel
     * @since 1.0
     */
    private StaticInObjectDeclarationJava() {
    }

    //region Two additional methods (getter & setter) for private field staticExample
    @NotNull
    public final String getStaticExample() {
        return staticExample;
    }

    public final void setStaticExample(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        staticExample = var1;
    }
    //endregion

}
