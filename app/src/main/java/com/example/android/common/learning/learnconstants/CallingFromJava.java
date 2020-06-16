package com.example.android.common.learning.learnconstants;

/**
 * 6/16/2020
 * Unlike kotlin, we have to write {@code public} keyword in Java.
 * In kotlin, classes are {@code public} by default. We don't have to write.
 * Unlike kotlin, we have to write {@code final} keyword in Java to save the class from inheritance.
 * In kotlin, classes are {@code final} by default. They cant be inherited unless we mark it as {@code open}.
 *
 * @author srdpatel
 * @see <a href="https://kotlinlang.org/docs/reference/classes.html">Classes and Inheritance</a>
 * @see <a href="https://kotlinlang.org/docs/reference/visibility-modifiers.html">Visibility modifiers</a>
 * @since 1.0
 */
public final class CallingFromJava {

    /**
     * 6/16/2020
     * Accessing java static like variable of kotlin from java.
     * We can access {@link StaticInObjectDeclaration#jvmStaticExample} as it has {@code @JvmField} annotation.
     * But we cannot access {@link StaticInObjectDeclaration#staticExample} as it lacks {@code @JvmField} annotation.
     *
     * @author srdpatel
     * @see <a href="https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html">Java interop</a>
     * @since a
     */
    private void accessStaticVarFromObjDeclaration() {
        String jvmStaticExample = StaticInObjectDeclarationJava.jvmStaticExample;
        //String staticExample = StaticInObjectDeclaration.staticExample; Not possible due to lack of @JvmField annotation
    }
}
