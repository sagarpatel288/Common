package com.example.android.common.learning;

/*outer class cannot be a static class*/
public /*static*/ class OuterInnerAccess {

    /**
     * We can define the nested-static class as abstract.
     */
    public abstract static class AbstractStaticInner {

    }

    static String staticVar;
    final String FINAL_STRING;
    int outPublic = 20;
    private int outPrivate = 10;
    /*static final String STATIC_FINAL;*/ //Must be declared and defined before class loading is finished.

    /**
     * 11/9/2020 12:46
     * <p>
     * Initialization of a static and a final variable is possible inside a constructor but
     * not for the static final variable.
     *
     * @author srdpatel
     * @see <a href="http://oogle.com">a</a>
     * @since a
     */
    public OuterInnerAccess() {
        staticVar = "a static variable";
        FINAL_STRING = "a final string";
        /*STATIC_FINAL = "";*/
    }

    public static void outerStatic() {
        System.out.println("A static method of an outer class");
    }

    public void outerMethod() {
        System.out.println("outer method");
    }

    /*We can access private members of an inner class from the outer class*/
    public void accessInner() {

        /*To access members of the inner class, we need an object of the inner class*/
        InnerClass innerClass = new InnerClass();
        innerClass.inner = 1;
        innerClass.in = 2;
        System.out.println(innerClass.inner + " " + innerClass.in);
    }

    private interface InterfaceEx {

    }

    static class innerStaticClass {

    }

    public abstract class AbstractInnerClass {

    }

    class InnerClass {

        private int in = 1;
        private int inner = outPublic;

        public void changeOuterVar() {
            /*Yes! We can access a private member of an outer class
            from the inner class because the inner class is also a member of the outer class!*/
            outPrivate = 0;
            outPublic = 30;
        }

        /*An inner class cannot have a static member*/
        public /*static*/ void staticMethod() {
            /*static*/
            int staticInt = 10;
        }
    }
}
