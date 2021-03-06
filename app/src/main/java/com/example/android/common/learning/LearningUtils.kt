package com.example.android.common.learning

import com.example.android.common.basedto.BaseUserInfo
import com.example.android.common.learning.learnconstants.FinalInObjectDeclaration
import java.util.*

class LearningUtils : (Int, Int) -> Int {

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

    //region A higher order function that has one and only function type parameter
    private fun doSomething(ft: (Int, Int) -> Int) {
        val result = ft(1, 2)
        /*...*/
    }
    //endregion

    //region A function type that has only one parameter
    private fun doSomethingX(ft: (Int) -> String) {
        /*...*/
    }
    //endregion

    //region A function type that has no parameter
    private fun doSomethingY(ft: () -> String) {
        /*...*/
    }
    //endregion

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

    private fun getSomeValue(): Int? = (10..100).random()

    private fun getSomeValue(nullableString: String?): StringBuilder? =
        if (nullableString != null) StringBuilder(nullableString) else null

    private fun getEvenOrZero(randomNumber: Int): Int =
        if (randomNumber.rem(2) == 0) randomNumber else 0

    private fun getEvenOrNull(randomNumber: Int): Int? =
        if (randomNumber.rem(2) == 0) randomNumber else null

    private fun getHalf(number: Int?): Int = number?.div(2) ?: 0

    private fun division(number: Int, divideBy: Int): Int = number / divideBy

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
        val sum = { a: Int, b: Int ->
            println()
            a + b
        }

        // comment by srdpatel: 4/22/2020 How to use function literal
        println("function literal with arguments: " + sum.invoke(1, 2))
        println("calling function literal stored in a variable: " + sum(1, 2))

        /**
         * While calling the higher order function When the function type parameter is one and only parameter,
         * and if the function type has also one and only parameter,
         * in addition to function call parentheses, we can also omit the function type parameter and an arrow ```->```
         * We just write core business logic between curly braces
         * and we can access our single parameter through the keyword it like below:
         */
        doSomethingX { "$it" }

        /**
         * 5/8/2020
         * A function type without any parameter
         * <p>
         * if the higher order function has only one function type parameter and the function type has no parameter,
         * We can simply write our business logic between curly parentheses right after the name of the function.
         * </p>
         * @author srdpatel
         * @since 1.0
         */
        doSomethingY { "test" }

        /**
         * 4/21/2020
         * comment by srdpatel: 4/19/2020 Usage of function literal in higher order function
         * <p>
         * In order to execute this function literal, higher order function must call this function literal.
         * So it will be like a function call for function literal from higher order function.
         * </p>
         * If the function type parameter is the last parameter in a higher order function,
         * while calling such a higher order function, we can write our lambda (function literal)
         * after the function call as done in this call.
         * </p>
         * @see <a href="http://google.com"></a>
         * [ReadableHyperlinkText]( "")
         * @author srdpatel
         * @since 1.0
         */
        doSomethingReturnUnit(3, 4) { a: Int, b: Int ->
            FinalInObjectDeclaration.FINAL_CONSTANT
            println("printing from function literal")
            a + b
        }

        /**
         * 5/7/2020
         * Last statement is considered as return statement for a function literal
         * <p>
         * (Tags: method function code in markdown doc comment example)
         * Below method will give an error:
         * ```
         * Type mismatch.
         * Required: Int
         * found: Unit
         * ```
         * Because, the last statement of a function literal we have passed as an argument,
         * makes the return type: [Unit] whereas the higher order function [doSomethingReturnUnit]
         * expects the function type argument to return [Int]
         * </p>
         * @author srdpatel
         * @since 1.0
         */
//        doSomethingReturnUnit(3,4){a: Int, b: Int -> println()}

        /**
         * While calling the higher order function When the function type parameter is only parameter,
         * we can simply write our business logic between curly braces after writing the function name
         * and omit function call parentheses like below:
         */
        doSomething { x: Int, y: Int -> x + y }

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

        //region Extension function
        /**
         * 4/30/2020
         * An example of Extension function
         * <p>
         * In kotlin, we can add a new function for any class anywhere, even in any other class.
         * Such a function is called an “Extension function” and
         * we can use such an extension function only inside the class where it is created.
         * In order to create an extension function,
         * we write the class name followed by a dot, followed by our function.
         * The class name followed by a dot is called a receiver or receiver type.
         * In this example, receiver type is: String
         * </p>
         *
         * @author srdpatel
         * @since 1.0
         */
        fun String.extensionFunction() {
            toUpperCase(Locale.ENGLISH)
            //We can access the receiver (Here, it is String) using "this" keyword inside the block
            println("from extension function: $this")
        }

        val myString = "MyString"
        myString.extensionFunction() //prints: from extension function: MyString

        fun BaseUserInfo.extensionFunction() {
            val userName = this.defaultName
            println("from extension function: ${this.defaultName}")
        }

        val userInfo = BaseUserInfo()
        userInfo.extensionFunction()

        //region Extension function with same receiver type as in function type parameter
        fun String.extensionFunction(ft: String.() -> String) {
            val ftExtension = ft()
            println("from extension function: $ftExtension")
        }

        val ftExtension: String.() -> String = { "from ft extension: $this" }
        myString.extensionFunction(ftExtension) //prints: from extension function: from ft extension: MyString
        //endregion

        //region Extension function type parameter in higher order function
        fun doSomething(x: Int, y: Int, ft: Int.(Int) -> Int) {
            val ftWithReceiver = x.ft(y) //OR ft(x, y) where x is considered as a receiver.
            println("doSomething: $ftWithReceiver")
        }

        //A lambda with receiver type. Accessing the receiver by using the keyword: this
        val ftSubtraction: Int.(Int) -> Int = { y: Int -> this - y }

        //passing as a function literal. Accessing the receiver by using the keyword: this
        doSomething(1, 2) { y: Int -> this - y } //prints: doSomething: -1

        //passing a lambda for the higher order function
        doSomething(1, 2, ftSubtraction) //prints: doSomething: -1


        //endregion


        //endregion

        //region Same receiver type for both an extension function and its function type param
        fun Int.doSomething(y: Int, ft: Int.(Int) -> Int) {
            //In such case, we can omit the receiver while calling function type
            val ftWithReceiver = ft(y)
            println("doSomething: $ftWithReceiver")
        }

        //passing as an anonymous function
        1.doSomething(2) { y: Int -> this - y } //prints: doSomething: -1

        //passing a lambda for the higher order function
        1.doSomething(2, ftSubtraction) //prints: doSomething: -1
        //endregion

        //region Scope functions
        val name = "test"
        var sb: StringBuilder? = StringBuilder("test")

        fun doSomething(name: String) {
            println("Name from the method doSomething is: $name")
        }

        fun getSbOrNull(nullableString: String?): java.lang.StringBuilder? {
            return if (nullableString != null) java.lang.StringBuilder(nullableString) else null
        }

        //region without with, demonstrating how we had to take an extra variable for multiple operations
        fun withoutWith() {
            val randomNumber = (1..10).random()
            println("withoutWith: divide by 2:  ${randomNumber.div(2)}")
            println("withoutWith: multiply by 2: ${randomNumber.times(2)} ")
            println("withoutWith: plus 2: ${randomNumber.plus(2)}")
        }
        //endregion

        //region with, demonstrating how we can avoid an extra variable using "with" scope function
        fun withDemo() {
            with((1..10).random()) {
                println("withDemo: divide by 2:  ${this.div(2)}")
                println("withDemo: multiply by 2: ${this.times(2)} ")
                println("withDemo: plus 2: ${this.plus(2)}")
            }
        }
        //endregion

        //region with demo without using explicit this
        fun withNoThisDemo() {
            with((1..10).random()) {
                println("withDemoWithoutThis: divide by 2:  ${div(2)}")
                println("withDemoWithoutThis: multiply by 2: ${times(2)} ")
                println("withDemoWithoutThis: plus 2: ${plus(2)}")
            }
        }
        //endregion

        //region with, demonstrating multiple operations on a nullable variable
        fun withOnNullable() {
            println("withNullableDemo...")
            with(getEvenOrNull((1..10).random())) {
                println("withNullableDemo: divide by 2:  ${this?.div(2)}")
                println("withNullableDemo: multiply by 2: ${this?.times(2)} ")
                println("withNullableDemo: plus 2: ${this?.plus(2)}")
            }
        }
        //endregion

        //region let, demonstrating how it is useful for multiple operations on a nullable variable
        fun letDemo() {
            println("letDemo...")
            getEvenOrNull((1..10).random())?.let {
                println("letDemo: divide by 2:  ${it.div(2)}")
                println("letDemo: multiply by 2: ${it.times(2)} ")
                println("letDemo: plus 2: ${it.plus(2)}")
            }
        }
        //endregion

        //region A chain operation without let
        fun equivalentOfLet() {
            //[sb] is a nullable [StringBuilder] here.
            println("the original string builder: $sb")
            sb?.reversed()
            val ts = sb?.toString()
            println("reversed string: $ts")
            val tsUc = ts?.toUpperCase(Locale.ENGLISH)
            println("capital: $tsUc")
            doSomething(tsUc ?: "") //[doSomething] is a function that accepts a string argument
        }
        //endregion

        //region let, demonstrating how it is useful for nullable variable
        /**
         * 6/3/2020
         * [sb] is a nullable [StringBuilder]
         * @author srdpatel
         * @since 1.0
         */
        fun letChainOperation() {
            //[sb] is a nullable [StringBuilder] here.
            sb?.let {
                //it refers to a StringBuilder here
                println("the original string builder: $it")
                it.reversed()
                it.toString()
                //            println(it) //It makes the return type unit and the next chain call of any function will be on Unit
            }?.let {
                //it refers to a String type here
                println("reversed string: $it")
                it.toUpperCase(Locale.ENGLISH)
            }?.let {
                //it is a String type with all upper case letters here
                println("capital: $it")
                doSomething(it) //[doSomething] is a function that accepts a string argument
            }
        }
        //endregion

        //region let, demonstrating a chain operation using let
        StringBuilder("test").let {
            //it refers to a StringBuilder here
            println("the original string builder: $it")
            it.reversed()
            it.toString()
//            println(it) //It makes the return type unit and the next chain call of any function will be on Unit
        }.let {
            //it refers to a String type here
            println("reversed string: $it")
            it.toUpperCase(Locale.ENGLISH)
        }.let {
            //it is a String type with all upper case letters here
            println("capital: $it")
            doSomething(it) //[doSomething] is a function that accepts a string argument
        }
        //endregion

        //region Multiple operations without let on nullable variables
        fun withoutLet() {
            println("without let...")
            val randomNumber = getEvenOrNull((10..100).random())
            if (randomNumber != null) {
                println("the random number is: $randomNumber")
                val sbon = StringBuilder(randomNumber.toString())
                println("the original string builder is: $sbon")
                val append = sbon.append(" test")
                println("appended test: $append")
                val rs = append.reversed()
                println("reversed string: $rs")
                val tsUc = rs.toString().toUpperCase(Locale.ENGLISH)
                println("toUpperCase: $tsUc")
                doSomething(tsUc ?: "")//[doSomething] is a function that accepts a string argument
            } else {
                println("null value")
            }
        }
        //endregion

        //region A chain operation with let on a nullable variable
        fun letChainOperationOnNullable() {
            println("with let...")
            getEvenOrNull((10..100).random())?.let {
                println("the random number is: $it")
                StringBuilder(it.toString())
            }?.let {
                println("the original string builder is: $it")
                it.append(" test")
            }?.let {
                println("appended test: $it")
                it.reversed()
            }?.let {
                println("reversed string: $it")
                it.toString().toUpperCase(Locale.ENGLISH)
            }?.let {
                println("toUpperCase: $it")
                doSomething(it)
            } ?: println("null value")
        }
        //endregion

        letChainOperationOnNullable()

        //region A chain operation with run on a nullable variable
        fun runChainOperationOnNullable() {
            println("with run...")
            getEvenOrNull((10..100).random())?.run {
                println("the random number is: $this")
                StringBuilder(toString())
            }?.run {
                println("the original string builder is: $this")
                append(" test")
            }?.run {
                println("appended test: $this")
                reversed()
            }?.run {
                println("reversed string: $this")
                toString().toUpperCase(Locale.ENGLISH)
            }?.run {
                println("toUpperCase: $this")
                doSomething(this)
            } ?: println("null value")
        }
        //endregion

        runChainOperationOnNullable()

        //region A chain operation using run + let on a nullable variable
        fun runLetChainOperationOnNullable() {
            println("using run + let...")
            getEvenOrNull((10..100).random())?.run {
                println("the random number is: $this")
                StringBuilder(toString())
            }?.run {
                println("the original string builder is: $this")
                append(" test")
            }?.run {
                println("appended test: $this")
                reversed()
            }?.run {
                println("reversed string: $this")
                toString().toUpperCase(Locale.ENGLISH)
            }?.let {
                //yes, we have used let instead of run here because passing "it" seems better than passing "this"!
                println("toUpperCase: $it")
                doSomething(it)
            } ?: println("null value")
        }
        //endregion

        runLetChainOperationOnNullable()

        //region A chain operation using run + let + also on a nullable variable
        fun runLetAlsoChainOperationOnNullable() {
            println("using runLetAlso...")
            getEvenOrNull((10..100).random())?.also {
                println("the random number is: $it")
                //Any operation on the context object will not change the object!
                it.plus(2)
                it.compareTo(50)
            }?.run {
                StringBuilder(toString())
            }?.also {
                println("the original string builder is: $it")
            }?.run {
                append(" test")
            }?.also {
                println("appended test: $it")
            }?.run {
                reversed()
            }?.also {
                println("reversed string: $it")
            }?.run {
                toString().toUpperCase(Locale.ENGLISH)
            }?.let {
                println("toUpperCase: $it")
                doSomething(it)
            } ?: println("null value")
        }
        //endregion

        runLetAlsoChainOperationOnNullable()

        //region A chain operation using run + let + also + apply on a nullable variable
        fun runLetAlsoApplyChainOperationOnNullable() {
            println("with runLetAlsoApply...")
            getEvenOrNull((10..100).random())?.also {
                println("the random number is: $it")
            }?.apply {
                //Any operation on the context object will not change the object!
                plus(2)
                compareTo(50)
            }?.run {
                StringBuilder(toString())
            }?.also {
                println("the original string builder is: $it")
            }?.run {
                append(" test")
            }?.also {
                println("appended test: $it")
            }?.run {
                reversed()
            }?.also {
                println("reversed string: $it")
            }?.run {
                toString().toUpperCase(Locale.ENGLISH)
            }?.let {
                println("toUpperCase: $it")
                doSomething(it)
            } ?: println("null value")
        }
        //endregion

        runLetAlsoApplyChainOperationOnNullable()

        //region run, demonstrating how it is useful for nullable variable
        fun runDemo() {
            //[sb] is a nullable [StringBuilder]
            sb?.run {
                //[this] refers to a StringBuilder here
                println("the original string builder: $this")
                reversed()
                toString()
//            println(this) //It makes the return type unit and the next chain call of any function will be on Unit
            }?.run {
                //[this] refers to a String type here
                println("reversed string: $this")
                toUpperCase(Locale.ENGLISH)
            }?.run {
                //[this] is a String type with all upper case letters here
                println("capital: $this")
                doSomething(this) //[doSomething] is a function that accepts a string argument
            }
        }
        //endregion

        //region let + run, demonstrating how it is useful
        fun letRunDemo() {
            //[sb] is a nullable [StringBuilder]
            sb?.run {
                //this refers to a StringBuilder here
                println("the original string builder: $this")
                reversed()
                toString()
//            println(this) //It makes the return type unit and the next chain call of any function will be on Unit
            }?.run {
                //this refers to a String type here
                println("reversed string: $this")
                toUpperCase(Locale.ENGLISH)
            }?.let {
                //[it] is a String type with all upper case letters here
                println("capital: $it")
                doSomething(it) //[doSomething] is a function that accepts a string argument
            }
        }
        //endregion

        //region let + T.run + also
        fun letRunAlso() {
            sb?.also {
                //it refers to a StringBuilder here
                println("the original string builder: $it")
                //Any operation on the context object inside the also block does not change the object
                sb = StringBuilder("new by also")
                //"also" returns the object instead of the last statement! Here, it returns stringBuilder instance "sb".
            }?.run {
                reversed()
                toString()
//            println(it) //It makes the return type unit and the next chain call of any function will be on Unit
            }?.also {
                //it refers to a String type here
                println("reversed string: $it")
            }?.run {
                toUpperCase(Locale.ENGLISH)
            }?.also {
                //it is a String type with all upper case letters here
                println("capital: $it")
            }?.let {
                doSomething(it) //[doSomething] is a function that accepts a string argument
            } ?: run {
                println("string is null")
            }
        }
        //endregion

        //region compare let + run in Elvis
        fun letRun() {
            var random: Int? = null
            //Take the variable global when you test
            random?.let {
                println("Random number is not null...")
                println(it)
                println("Gave random number")
            }
                ?: kotlin.run {
                    println("Generating random number...")
                    random = (1..100).random()
                    println("Generated number is: $random")
                }
        }

        fun withoutLetRun() {
            //Take the variable global when you test
            var random: Int? = null
            if (random != null) {
                println("Random number is not null...")
                println(random.toString())
                println("Gave random number")
            } else {
                println("Generating random number...")
                random = (1..100).random()
                println("Generated number is: $random")
            }
        }

        //endregion

        //region else part will not be executed
        fun computeElements(): List<Int>? = emptyList()

        fun letDoesNothing() {
            val maxElement = computeElements()?.let { it.max() } ?: return
            // This will print nothing...
            println("Max element was $maxElement")
        }

        fun compareLet() {
            val list: List<Int>? = computeElements()
            fun newTest() {
                val maxElement = if (list != null) list.max() else return
                // This will print...
                println("Max element was $maxElement")
            }
        }
        //endregion

        //region with
        fun withLetDemo() {
            with(name) {
                println("the original name is: $this")
                reversed()
                toUpperCase(Locale.ENGLISH)
            }.let {
                doSomething(it)
            }
        }
        //endregion

        //endregion
    }

    /**
     * 4/24/2020
     * Override method when we implement a function type
     * <p>
     * Like an interface, we can implement a function type too.
     * When we implement a function type, we get a method called "invoke" to override having a similar signature of the
     * implemented function type
     * </p>
     *  {@link #} []
     *
     * @author srdpatel
     * @see <a href="http://google.com"></a>
     * [ReadableHyperlinkText]( "")
     * @since 1.0
     */
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }

    fun BaseUserInfo.myExtensionFunction(): String {
        return this.userId + " " + this.defaultName
    }

    //region Inline function
    inline fun Int.doSomething(y: Int, noinline ftOne: Int.(Int) -> Int, ftTwo: (Int) -> Int) {
        val funOne =
            someFunction(ftOne) //passing a function type to another function within higher order function body
        val funTwo = ftTwo(y)//executing / calling [ftTwo]
        /*...*/
    }

    //region Compiler suggestion to not use [inline] keyword if the only lambda parameter is [noinline]
    inline fun Int.extensionFun(y: Int, noinline ftOne: Int.(Int) -> Int) {
        val funOne =
            someFunction(ftOne) //passing a function type to another function within higher order function body
        /*...*/
    }
//endregion

    fun someFunction(ft: Int.(Int) -> Int): Int {
        val result = 2.ft(1)
        println("from some function: $result")
        return result
    }
//endregion
}