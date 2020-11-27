package com.example.android.common.learning;

class UpDownCasting {

}


class A {

    String x = "from class A";

    public void print() {
        System.out.println("From class A.print");
    }

    public void dedicatedA() {
        System.out.println("From class A.dedicatedA");
    }
}

class B extends A {

    String x = "from class B";

    @Override
    public void print() {
        System.out.println("From class B.print");
    }

    public void dedicatedB() {
        System.out.println("From class B.dedicatedB");
    }
}

class Learn {
    public static void main(String[] args) {

        A a = new B(); //Implicit casting. Compiler knows, a parent can refer child object.
        a.print(); //calls overridden method from the class B
        /*a.dedicatedB();*/ // we cannot access specific and dedicated methods of the child class
        a.dedicatedA(); //we can access all the methods of super (parent)
        System.out.println(a.x); //magic! It refers to parent member.

        B b = (B) a; //Explicit casting. Compiler cannot decide which child object to cast.
        b.print(); //Method of the child class
        b.dedicatedA(); //We can also access methods of the parent class.
        b.dedicatedB(); //We can also access dedicated methods of the child class.
        System.out.println(b.x); //prints child member.
    }
}
