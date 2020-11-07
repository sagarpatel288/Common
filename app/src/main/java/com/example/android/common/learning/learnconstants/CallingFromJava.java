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

    private void accessingTopLevelVar(){

    }

    /**
     * 6/16/2020
     * Accessing java {@code static} like members of kotlin from java.
     * <p>
     * We can access {@link StaticInObjectDeclaration#jvmStaticExample} as it has {@code @JvmField} annotation.
     * But we cannot access {@link StaticInObjectDeclaration#staticExample} as it lacks {@code @JvmField} annotation.
     * <p>
     * Similarly, we can access {@link StaticInObjectDeclaration#jvmStaticMethod()} as it has {@code @JvmStatic} annotation.
     * But we cannot access {@link StaticInObjectDeclaration#staticMethod()} as it lacks {@code @JvmStatic} annotation.
     * </p>
     *
     * @author srdpatel
     * @see <a href="https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html">Java interop</a>
     * @since 1.0
     */
    private void accessMembersOfObjDeclaration() {
//        String staticExample = StaticInObjectDeclaration.staticExample; Not possible due to lack of @JvmField annotation
//        String staticMethodExample = StaticInObjectDeclaration.staticMethod(); Not possible due to lack of @JvmStatic annotation

        String jvmStaticExample = StaticInObjectDeclarationJava.jvmStaticExample;
        String jvmStaticMethodExample = StaticInObjectDeclaration.jvmStaticMethod();
    }

    /**
     * 6/17/2020
     * Accessing java {@code static} like members of kotlin {@code companion object} from java.
     * We can access fields marked with {@code @JvmField} and methods marked with {@code @JvmStatic}.
     *
     * @author srdpatel
     * @see <a href="https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html">Java interop</a>
     * @since 1.0
     */
    private void accessMembersOfCompanion() {
//        Not possible due to lack of `@JvmField` for fields and `@JvmStatic` for methods.
//        String staticExample = StaticInCompanionObjectClass.staticExample;
//        String jvmStaticMethodExample = StaticInCompanionObjectClass.staticMethod();

        String jvmStaticExample = StaticInCompanionObjectClass.jvmStaticExample;
        String jvmStaticMethodExample = StaticInCompanionObjectClass.jvmStaticMethod();
    }

    /**
     * 6/18/2020
     * Accessing java {@code public static final} like kotlin top-level members.
     * We can access top-level members even those without having {@code @JvmField} annotation.
     *
     * @author srdpatel
     * @since 1.0
     */
    private void accessVal() {

        /*
         * 6/19/2020
         * [topLevelVal] is defined at top-level as:
         * ```
         * val topLevelVal = "top-level val"
         * ```
         * The original variable is private and we are accessing it using generated getter.
         *
         * @author srdpatel
         * @since 1.0
         */
        String topLevelVal = ValInClassKt.getTopLevelVal();

        /*
         * 6/19/2020
         * [constValOutsideClass] is defined at top-level as:
         * ```
         * const val constValOutsideClass = "a const val outside the class at top-level"
         * ```
         * We can access the kotlin top-level "const val" in java even if it lacks "@JvmField" annotation.
         *
         * @author srdpatel
         * @since 1.0
         */
        String constValOutsideClass = ValInClassKt.constValOutsideClass;

        /*
         * 6/19/2020
         * [jvmFieldValOutsideClass] is defined at top-level as:
         * ```
         * @JvmField
         * val jvmFieldValOutsideClass = "jvmField val outside the class at top-level"
         * ```
         * @author srdpatel
         * @since 1.0
         */
        String jvmFieldValOutsideClass = ValInClassKt.jvmFieldValOutsideClass;

        /*
         * 6/19/2020
         * [topLevelFun] is defined at top-level as:
         * ```
         * fun topLevelFun() = "top-level function"
         * ```
         * @author srdpatel
         * @since 1.0
         */
        String topLevelFun = ValInClassKt.topLevelFun();
    }

    private void accessVar() {
        VarInClass varInClass = new VarInClass();
        varInClass.getVarInClassCompileTime();
        varInClass.setVarInClassCompileTime("from java setter: var in class: compile time");
        varInClass.getVarInClassRunTime();
        varInClass.setVarInClassRunTime("from java setter: var in class: run time");
        varInClass.jvmFieldVarInClass = "new value from java";
        varInClass.publicFun();
    }
}
