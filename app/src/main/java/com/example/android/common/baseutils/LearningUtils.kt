package com.example.android.common.baseutils

class LearningUtils {

    /**
     * 4/19/2020
     * Higher order function []
     * <p>
     * The last parameter is known as: lambda parameter or function type
     * </p>
     * @see <a href="http://google.com"></a>
     * [ReadableHyperlinkText]( "")
     * @author srdpatel
     * @since 1.0
     */
    fun doSomething(a: Int, b: Int, myFunction: (Int, Int) -> Int) {

    }

    fun whatever() {

        //region Lambda expression
        // comment by srdpatel: 4/19/2020 Assigning a lambda expression to the variable
        val sum: (Int, Int) -> Int = { a, b -> a + b }
        val subtraction = { a: Int, b: Int -> a - b }

        // comment by srdpatel: 4/19/2020 Assigning a lambda expression with single parameter to the variable
        val increment: (Int) -> Int = { it + 1 }

        // comment by srdpatel: 4/19/2020 Usage of lambda expression in higher order function
        doSomething(1, 2, sum)
        doSomething(2, 3, subtraction)
        //endregion

        //region Function literal
        // comment by srdpatel: 4/19/2020 Usage of function literal in higher order function
        doSomething(3, 4) { a: Int, b: Int -> a * b }
        //endregion

        //region Anonymous function
        // comment by srdpatel: 4/19/2020 Assigning an anonymous function to a variable. Function type and return type are inferred.
        val anonymousFunction = fun(a: Int, b: Int) = a + b
        // comment by srdpatel: 4/19/2020 Assigning an anonymous function to a variable. Data type of parameter and return type are inferred.
        val anonymousFun: (Int, Int) -> Int = fun(a, b) = a + b
        // comment by srdpatel: 4/19/2020 Anonymous function with a single parameter
        val anonymous: (Int) -> Int = fun(a) = a + 1

        // comment by srdpatel: 4/19/2020 Usage of anonymous function in higher order function
        doSomething(2, 3, anonymousFunction)

        // comment by srdpatel: 4/19/2020 Anonymous function
        doSomething(5, 6,
            fun(a: Int, b: Int): Int = a + b / 2)
        //endregion
    }
}