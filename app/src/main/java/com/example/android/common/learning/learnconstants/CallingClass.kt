package com.example.android.common.learning.learnconstants

/**
 * 6/16/2020
 * Accessing java static like members defined inside of an object declaration and a companion object.
 * @author srdpatel
 * @since 1.0
 */
fun main() {

    //region Accessing members of an object declaration
    println(StaticInObjectDeclaration.staticExample + " " + StaticInObjectDeclaration.jvmStaticExample)
    println(StaticInObjectDeclaration.staticMethod() + " " + StaticInObjectDeclaration.jvmStaticMethod())
    //endregion

    //region Accessing members of a companion object
    println(StaticInCompanionObjectClass.staticExample + " " + StaticInCompanionObjectClass.jvmStaticExample)
    println(StaticInCompanionObjectClass.staticMethod() + " " + StaticInCompanionObjectClass.jvmStaticMethod())
    //endregion
}

class CallingClass {

    //region Accessing variables defined inside an object declaration
    var refStaticInObjDeclaration = StaticInObjectDeclaration.staticExample
    var refJvmStaticInObjDeclaration = StaticInObjectDeclaration.jvmStaticExample
    //endregion

    //region Accessing methods defined inside an object declaration
    var refStaticMethodInObjDeclaration = StaticInObjectDeclaration.staticMethod()
    var refJvmStaticMethodInObjDeclaration = StaticInObjectDeclaration.jvmStaticMethod()
    //endregion

    //region Accessing variables defined inside a companion object
    var refStaticExample = StaticInCompanionObjectClass.staticExample
    var refJvmStaticExample = StaticInCompanionObjectClass.jvmStaticExample
    //endregion

    //region Accessing methods defined inside a companion object
    var refStaticMethod = StaticInCompanionObjectClass.staticMethod()
    var refJvmStaticMethod = StaticInCompanionObjectClass.jvmStaticMethod()
    //endregion
}