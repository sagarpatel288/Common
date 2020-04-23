package com.example.android.common.baseutils

class LearningUtils {

    /**
     * 4/20/2020
     * A higher order function
     * <p>
     * A function that has another function/s as parameter/s is known as a higher order function.
     * Function parameter is represented by: "anyName: (Comma separated data types) -> returnType".
     * The argument we pass must match with the signature of function parameter.
     * Function parameter is also known as function type, lambda parameter or lambda expression.
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
    private fun doSomethingReturnUnit(a: Int, b: Int, myFunction: (Int, Int) -> Int) {
        println("variable a is $a and b is $b")
        println(
            "invoking function type, function literal, lambda expression or your anonymous function"
        )
        myFunction(a, b) // OR: ```myFunction.invoke(a, b)```
    }

    fun doSomething(a: Int, b: Int, ft: (Int, Int) -> Int): String {
        val result = ft(a, b)
        return "doSomething: " + result
    }

    private fun percentage(a: Int, b: Int): Int {
        return ((a * b) * 100) / 100
    }

    private fun innerFunction(a: Int, b: Int): (Int, Int) -> Int {
        println("from inner function block: a is $a and b is $b")
        return { c, d -> c + d }
    }

    private fun max(varargs: String, compare: (String, String) -> Boolean) {

    }

    private fun compare(a: String, b: String): Boolean = a.length < b.length

    fun whatever() {

        // comment by srdpatel: 4/20/2020 notice the return type of "innerFunction"
        doSomethingReturnUnit(1, 2, innerFunction(3, 4))

        //region Function Type
        /**
         * 4/23/2020
         * Function Type
         * <p>
         * We know data types. Similarly, we have function type too in kotlin.
         * Below is the signature/syntax of a function type.
         * ```
         * Name: (only comma separated data types) -> return data type
         * ft: (Int, Int) -> Int
         * ```
         * In order to call/execute a function type, we do something like below:
         * ```
         * ft(1, 2)
         * OR
         * ft.invoke(1, 2)
         * ```
         * In order to use a function type as a parameter in a higher order function, we define a function type parameter
         * like below:
         * ```
         *  fun doSomething(a: Int, b: Int, ft: (Int, Int) -> Int): String {
         *     val result = ft(a, b) //OR ft.invoke(a, b)
         *     return “doSomething: ” + result
         *  }
         * ```
         * A function that takes one or more function type/s as a parameter/s is called higher order function.
         * for more information on higher order function, check [doSomethingReturnUnit]
         * </p>
         * We can store a function type in any variable like below:
         * ```
         * val functionType: (Int, Int) -> Int
         * ```
         * </p>
         * @author srdpatel
         * @since 1.0
         */
        val functionType: (Int, Int) -> Int
        val funType: (Int, Int) -> Int = innerFunction(4, 5)
        doSomethingReturnUnit(1, 2, funType)
        //endregion

        //region Function literal

        // comment by srdpatel: 4/22/2020 Function literal stored in a variable
        val sum = { a: Int, b: Int -> a + b }

        // comment by srdpatel: 4/22/2020 How to use function literal
        println("function literal with arguments: " + sum.invoke(1, 2))
        println("calling function literal stored in a variable: " + sum(1, 2))

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
        doSomethingReturnUnit(3, 4) { a: Int, b: Int ->
            println("printing from function literal")
            a + b
        }
        //endregion

        //region Lambda expression
        /**
         * 4/21/2020
         * comment by srdpatel: 4/19/2020 Assigning a lambda expression to the variable []
         * <p>
         * This lambda expression has a explicit function type (Int, Int) -> Int.
         * This lambda expression is equivalent to below function:
         * ```
         * fun sum (a:Int, b:Int): Int {
         *  println("sum")
         *  return a + b
         * }
         * ```
         * </p>
         * @see <a href="http://google.com"></a>
         * [ReadableHyperlinkText]( "")
         * @author srdpatel
         * @since 1.0
         */
        val lambdaSum: (Int, Int) -> Int = { a, b ->
            println("lambda sum")
            // comment by srdpatel: 4/21/2020 Last statement is considered as return in lambda expression
            a + b
        }

        // comment by srdpatel: 4/21/2020 The function type of this lambda expression is inferred as: (Int, Int) -> Int
        val lambdaSubtraction = { a: Int, b: Int ->
            println("lambda subtraction")
            // comment by srdpatel: 4/21/2020 Last statement is considered as return in lambda expression
            a - b
        }

        // comment by srdpatel: 4/19/2020 Assigning a lambda expression with single parameter to the variable
        val increment: (Int) -> Int = {
            println("increment")
            // comment by srdpatel: 4/21/2020 Last statement is considered as return in lambda expression
            it + 1
        }

        /**
         * 4/22/2020
         * comment by srdpatel: 4/19/2020 Usage of lambda expression in higher order function []
         * <p>
         * Calling that "doSomething" function and passing our lambda expression as an argument.
         * Note that we are not passing the lambda expression with arguments like lambdaSum(3,4)
         * because then it will not match with the signature of the function parameter.
         * </p>
         * @see <a href="http://google.com"></a>
         * [ReadableHyperlinkText]( "")
         * @author srdpatel
         * @since 1.0
         */
        doSomethingReturnUnit(1, 2, lambdaSum)
        doSomethingReturnUnit(2, 3, lambdaSubtraction)
        //endregion

        //region Anonymous function
        // comment by srdpatel: 4/19/2020 Assigning an anonymous function to a variable. Function type and return type are inferred.
        val anonymousFunction = fun(a: Int, b: Int) = a + b
        // comment by srdpatel: 4/19/2020 Assigning an anonymous function to a variable. Data type of parameter and return type are inferred.
        val anonymousFun: (Int, Int) -> Int = fun(a, b) = a + b
        // comment by srdpatel: 4/19/2020 Anonymous function with a single parameter. There is nothing like "it" in lambda
        val anonymous: (Int) -> Int = fun(a) = a + 1

        // comment by srdpatel: 4/19/2020 Usage of anonymous function in higher order function
        doSomethingReturnUnit(2, 3, anonymousFunction)
        doSomethingReturnUnit(1, 2, anonymousFun)

        // comment by srdpatel: 4/19/2020 Anonymous function
        doSomethingReturnUnit(5, 6,
            fun(a: Int, b: Int): Int = a + b / 2)
        //endregion
    }
}