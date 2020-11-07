package com.example.android.common.learning.learnconstants;

public class CallingVarIn {

    public static void main(String[] args) {
        accessVar();
    }

    /**
     * 6/23/2020
     * <p>
     * Accessing kotlin members.
     * </p>
     *
     * @author srdpatel
     * @since 1.0
     */
    public static void accessVar() {
        VarInClass varInClass = new VarInClass();

        String varInClassCompileTime = varInClass.getVarInClassCompileTime();
        System.out.println(varInClassCompileTime);

        varInClass.setVarInClassCompileTime("from java setter: var in class: compile time");
        System.out.println(varInClass.getVarInClassCompileTime());

        String varInClassRunTime = varInClass.getVarInClassRunTime();
        System.out.println(varInClassRunTime);

        varInClass.setVarInClassRunTime("from java setter: var in class: run time");
        System.out.println(varInClass.getVarInClassRunTime());

        varInClass.jvmFieldVarInClass = "new value from java";
        System.out.println(varInClass.jvmFieldVarInClass);

        varInClass.publicFun();
    }
}
