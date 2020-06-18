package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;

class FinalValInClassJava {

    @NotNull
    private final String valFinalExample = this.someFunction();
    @JvmField
    @NotNull
    public final String jvmFieldFinalExample = this.someFunction();

    @NotNull
    public final String getValFinalExample() {
        return this.valFinalExample;
    }

    private final String someFunction() {
        return "from the function";
    }

}
