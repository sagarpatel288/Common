package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
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
     * @since 1.0
     */
    public static final StaticInObjectDeclarationJava INSTANCE; //singleton instance

    /**
     * 6/16/2020
     * Note the {@code public} visibility modifier.
     *
     * @since 1.0
     */
    @JvmField
    @NotNull
    public static String jvmStaticExample;

    /**
     * 6/16/2020
     * Note the {@code private} visibility modifier.
     *
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

    /**
     * 6/17/2020
     * {@code @JvmStatic} annotation makes the function accessible like a {@code static} method in Java.
     *
     * @author srdpatel
     * @see <a href="https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-methods">Kotlin-Java interop</a>
     * @since 1.0
     */
    @JvmStatic
    @NotNull
    public static final String jvmStaticMethod() {
        return "jvmStaticMethod";
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

    /**
     * 6/17/2020
     * A function without {@code @JvmStatic} annotation in an object declaration behaves like a {@code final} method in Java.
     *
     * @author srdpatel
     * @see <a href="https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-methods">Java-Kotlin interop</a>
     * @since 1.0
     */
    @NotNull
    public final String staticMethod() {
        return "staticMethod";
    }
}
