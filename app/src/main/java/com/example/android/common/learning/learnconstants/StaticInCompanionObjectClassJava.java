package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/**
 * 6/16/2020
 * Java equivalent class of kotlin companion object {@link StaticInCompanionObjectClass}
 *
 * @author srdpatel
 * @since 1.0
 */
public final class StaticInCompanionObjectClassJava {

    @JvmField
    @NotNull
    public static String jvmStaticExample = "jvmStaticExample";
    @NotNull
    private static String staticExample = "staticExample";

    public static final class StaticInCompanionObject {
        private StaticInCompanionObject() {
        }

        @NotNull
        public final String getStaticExample() {
            return StaticInCompanionObjectClassJava.staticExample;
        }

        public final void setStaticExample(@NotNull String var1) {
            Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
            StaticInCompanionObjectClassJava.staticExample = var1;
        }

        // $FF: synthetic method
        /*public StaticInCompanionObject(DefaultConstructorMarker $constructor_marker) {
            this();
        }*/
    }
}
