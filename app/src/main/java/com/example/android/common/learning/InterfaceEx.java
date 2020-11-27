package com.example.android.common.learning.learnconstants;

interface InterfaceEx {

    /*
     * All member variables in an interface are public static final by default.
     * */
    String INTERFACE_VAR = "A public string variable inside an interface";

    /*
     * We cannot define a private variable inside an interface
     * */
    /*private static final String INTERFACE_PRIVATE_VARIABLE = "A private variable inside an interface";*/

    /**
     * We cannot have a non-abstract method in an interface.
     * However, we can define a default method like {@link #defaultMethod()}
     */
    /*void nonAbstractMethod() {

    }*/

    /*private static method is not allowed here up to Java 8. From Java 9, we can.*/
    static void staticInterfaceMethod() {
        System.out.println("InterfaceEx.staticInterfaceMethod");
    }

    /**
     * We can define default methods in an interface from Java 8.
     * We can refer any abstract method or a variable of this class.
     */
    default void defaultMethod() {
        System.out.println(abstractMethod() + ": via InterfaceEx.defaultMethod: " + INTERFACE_VAR);
    }

    /**
     * 11/7/2020 14:27
     * We can declare an abstract method in an interface.
     *
     * @link {@link #defaultMethod()}
     * @author srdpatel
     * @since 1.0
     */
    String abstractMethod();
}
