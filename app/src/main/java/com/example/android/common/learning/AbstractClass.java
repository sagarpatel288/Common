package com.example.android.common.learning;

/*We cannot have a static outer class
* https://stackoverflow.com/questions/18036458/why-cant-we-have-static-outer-classes
* */
abstract /*static*/ class AbstractClass {

    static abstract class InnerAbstractClass {

    }
}
