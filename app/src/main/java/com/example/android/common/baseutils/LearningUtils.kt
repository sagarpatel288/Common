package com.example.android.common.baseutils

class LearningUtils {

    /**
     * 4/20/2020
     * A higher order function
     * <p>
     * A function that has another function/s as parameter/s is known as a higher order function.
     * Function parameter is
     * "doSomething" is a higher order function that has a function type (or say, lambda parameter) "(Int, Int) -> Int" as a last parameter.
     * It can also be said that “doSomething” has the last parameter as a lambda expression.
     * A functionType in any function as a parameter can be said as a lambda expression but
     * there is nothing such as functionType as an argument as it is always a lambda expression then.
     * </p>
     * @param myFunction This lambda expression will be called
     * @see <a href="http://google.com"></a>
     * [ReadableHyperlinkText]( "")
     * @author srdpatel
     * @since 1.0
     */
    private fun doSomething(a: Int, b: Int, myFunction: (Int, Int) -> Int) {
        println("variable a is $a and b is $b")
        println(
            "invoking function type, function literal, lambda expression or your anonymous function with " +
                    "a as hard literal 10 and b as hard literal 20 from higher order function"
        )
        myFunction(10, 20)
    }

    private fun innerFunction(a: Int, b: Int): (Int, Int) -> Int {
        println("from inner function block: a is $a and b is $b")
        return { c, d -> c + d }
    }

    fun whatever() {

        // comment by srdpatel: 4/20/2020 notice the return type of "innerFunction"
        doSomething(1, 2, innerFunction(3, 4))

        //region Function Type
        val functionType: (Int, Int) -> Int
        val funType: (Int, Int) -> Int = innerFunction(4, 5)
        doSomething(1,2, funType)
        //endregion

        //region Function literal
        /**
         * 4/21/2020
         * comment by srdpatel: 4/19/2020 Usage of function literal in higher order function
         * <p>
         * In order to execute this function literal, higher order function must call this function literal.
         * So it will be like a function call for function literal from higher order function.
         * </p>
         * @see <a href="http://google.com"></a>
         * [ReadableHyperlinkText]( "")
         * @author srdpatel
         * @since 1.0
         */
        doSomething(3, 4) { a: Int, b: Int ->
            println("printing from function literal")
            a + b
        }
        //endregion

        //region Lambda expression
        /**
         * 4/21/2020
         * comment by srdpatel: 4/19/2020 Assigning a lambda expression to the variable []
         * <p>
         * This lambda expression has a function type (Int, Int) -> Int.
         * </p>
         * @see <a href="http://google.com"></a>
         * [ReadableHyperlinkText]( "")
         * @author srdpatel
         * @since 1.0
         */
        val lambdaSum: (Int, Int) -> Int = { a, b ->
            println("lambda sum")
            // comment by srdpatel: 4/21/2020 Last statement is considered as return in lambda expression
            a + b }

        // comment by srdpatel: 4/21/2020 The function type of this lambda expression is inferred as: (Int, Int) -> Int
        val lambdaSubtraction = { a: Int, b: Int ->
            println("lambda subtraction")
            // comment by srdpatel: 4/21/2020 Last statement is considered as return in lambda expression
            a - b }

        // comment by srdpatel: 4/19/2020 Assigning a lambda expression with single parameter to the variable
        val increment: (Int) -> Int = {
            println("increment")
            // comment by srdpatel: 4/21/2020 Last statement is considered as return in lambda expression
            it + 1 }

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
        doSomething(1, 2, anonymousFun)

        // comment by srdpatel: 4/19/2020 Anonymous function
        doSomething(5, 6,
            fun(a: Int, b: Int): Int = a + b / 2)
        //endregion
    }
}