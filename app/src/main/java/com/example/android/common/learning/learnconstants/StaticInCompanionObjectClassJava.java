package com.example.android.common.learning.learnconstants;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/**
 * 6/16/2020
 * Java equivalent class of kotlin companion object {@link StaticInCompanionObjectClass}
 *
 * @author srdpatel
 * @since 1.0
 */
public final class StaticInCompanionObjectClassJava {

    /**
     * 6/17/2020
     * A static instance of the companion object.
     * Kotlin doc (given the link) says:
     * ```
     * "Even though the members of companion objects look like static members in other languages,
     * at runtime those are still instance members of real objects."
     * ```
     * This is the static instance here through which we would call various instance methods like
     * {@link StaticInCompanionObjectClassJava.StaticInCompanionObject#jvmStaticMethod()}.
     *
     * @see <a href="https://kotlinlang.org/docs/reference/object-declarations.html#companion-objects">Companion objects</a>
     * @since 1.0
     */
    public static final StaticInCompanionObjectClassJava.StaticInCompanionObject StaticInCompanionObject = new StaticInCompanionObjectClassJava.StaticInCompanionObject((DefaultConstructorMarker) null);

    /**
     * 6/16/2020
     * Note the {@code public} visibility modifier.
     *
     * @since 1.0
     */
    @JvmField
    @NotNull
    public static String jvmStaticExample = "jvmStaticExample";

    /**
     * 6/16/2020
     * Note the {@code private} visibility modifier.
     *
     * @since 1.0
     */
    @NotNull
    private static String staticExample = "staticExample";

    /**
     * 6/17/2020
     * <p>
     * Note that this method is inside of a companion object in actual Kotlin class {@link StaticInCompanionObjectClass#jvmStaticMethod()}
     * whereas here in Java equivalent (kotlin decompiler), we get both an instance method outside of the companion object
     * (this method) that will call the actual method {@link StaticInCompanionObject#jvmStaticMethod()} which is inside of the companion object.
     * <p>
     * {@code @JvmStatic} annotation makes the function accessible like a {@code static} method in Java.
     * However, kotlin compiler generates an instance method instead of a static method.
     * So, this is the instance method for {@link StaticInCompanionObjectClassJava#StaticInCompanionObject}
     * that is generated for and will call {@link StaticInCompanionObjectClassJava.StaticInCompanionObject#jvmStaticMethod()}
     * <p>
     * That's a way much complicated solution for a simple static method!
     * </p>
     *
     * @author srdpatel
     * @see <a href="https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-methods">Kotlin-Java interop</a>
     * @since 1.0
     */
    @JvmStatic
    @NotNull
    public static final String jvmStaticMethod() {
        return StaticInCompanionObject.jvmStaticMethod();
    }

    /**
     * 6/17/2020
     * Kotlin compiler turns the companion object into a class like this.
     *
     * @author srdpatel
     * @since 1.0
     */
    public static final class StaticInCompanionObject {

        /**
         * 6/16/2020
         * private constructor for a singleton pattern.
         *
         * @author srdpatel
         * @since 1.0
         */
        private StaticInCompanionObject() {
        }

        //region Two additional methods (getter & setter) for private field `staticExample`
        @NotNull
        public final String getStaticExample() {
            return StaticInCompanionObjectClassJava.staticExample;
        }

        public final void setStaticExample(@NotNull String var1) {
            Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
            StaticInCompanionObjectClassJava.staticExample = var1;
        }
        //endregion

        /**
         * 6/17/2020
         * <p>
         * Note that this is the instance method (and not a static method).
         * Hence, it will require an instance (an object) of this class {@link StaticInCompanionObjectClassJava.StaticInCompanionObject}
         * that can call this method.
         * <p>
         * So, the {@code @JvmStatic} annotation for a method inside a companion object in kotlin actually
         * creates a static method {@link StaticInCompanionObjectClassJava#jvmStaticMethod()} outside the companion object class
         * which will call this instance method of the class {@link StaticInCompanionObjectClassJava.StaticInCompanionObject}.
         * </p>
         *
         * @author srdpatel
         * @since 1.0
         */
        @JvmStatic
        @NotNull
        public final String jvmStaticMethod() {
            return "jvmStaticMethod";
        }

        /**
         * 6/17/2020
         * We didn't give the {@code @JvmStatic} annotation for this method in kotlin companion object.
         * Hence, We couldn't get a relevant static method that can call this method through
         * the instance of this {@link StaticInCompanionObjectClassJava#StaticInCompanionObject} class.
         *
         * @author srdpatel
         * @since 1.0
         */
        @NotNull
        public final String staticMethod() {
            return "staticMethod";
        }

        // $FF: synthetic method
        /*public StaticInCompanionObject(DefaultConstructorMarker $constructor_marker) {
            this();
        }*/
    }
}
