package com.example.android.common.learning.solid

fun main() {
    LiskovSubstitution().iteration()
}

class LiskovSubstitution {
    private val car: Car = Car(20)
    private val racingCar: Car = RacingCar(10)
    var listOfCars: List<Car> = listOf(car, racingCar)

    fun iteration() {
        listOfCars.forEach {
            println(it.cabinWidth)
        }
    }
}