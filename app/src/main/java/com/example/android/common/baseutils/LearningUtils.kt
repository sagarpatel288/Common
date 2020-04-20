package com.example.android.common.baseutils

class LearningUtils {

    /**
     * 4/20/2020
     * A higher order function []
     * <p>
     * A function that has another function/s as parameter/s is known as a higher order function.
     * "doSomething" is a higher order function that has a function type (or say, lambda parameter) "(Int, Int) -> Int" as a last parameter.
     * It can also be said that “doSomething” has the last parameter as a lambda expression.
     * A functionType in any function parameter can be said as a lambda expression but
     * there is nothing such as functionType as an argument as it is always a lambda expression then.
     * </p>
     * @see <a href="http://google.com"></a>
     * [ReadableHyperlinkText]( "")
     * @author srdpatel
     * @since 1.0
     */
    fun doSomething(a: Int, b: Int, myFunction: (Int, Int) -> Int) {

    }

    fun innerFunction(a: Int, b: Int): (Int, Int) -> Int {
        return { c, d -> c / d }
    }

    fun whatever() {

        // comment by srdpatel: 4/20/2020 notice the return type of "innerFunction"
        doSomething(1, 2, innerFunction(3, 4))

        //region Function literal
        // comment by srdpatel: 4/19/2020 Usage of function literal in higher order function
        doSomething(3, 4) { a: Int, b: Int -> a * b }
        //endregion

        //region Lambda expression
        // comment by srdpatel: 4/19/2020 Assigning a lambda expression to the variable
        val lambdaSum: (Int, Int) -> Int = { a, b -> a + b }
        val lambdaSubtraction = { a: Int, b: Int -> a - b }

        // comment by srdpatel: 4/19/2020 Assigning a lambda expression with single parameter to the variable
        val increment: (Int) -> Int = { it + 1 }

        // comment by srdpatel: 4/19/2020 Usage of lambda expression in higher order function
        doSomething(1, 2, lambdaSum)
        doSomething(2, 3, lambdaSubtraction)
        //endregion

        //region Anonymous function
        // comment by srdpatel: 4/19/2020 Assigning an anonymous function to a variable. Function type and return type are inferred.
        val anonymousFunction = fun(a: Int, b: Int) = a + b
        // comment by srdpatel: 4/19/2020 Assigning an anonymous function to a variable. Data type of parameter and return type are inferred.
        val anonymousFun: (Int, Int) -> Int = fun(a, b) = a + b
        // comment by srdpatel: 4/19/2020 Anonymous function with a single parameter. There is nothing like "it" in lambda
        val anonymous: (Int) -> Int = fun(a) = a + 1

        // comment by srdpatel: 4/19/2020 Usage of anonymous function in higher order function
        doSomething(2, 3, anonymousFunction)

        // comment by srdpatel: 4/19/2020 Anonymous function
        doSomething(5, 6,
            fun(a: Int, b: Int): Int = a + b / 2)
        //endregion
    }
}