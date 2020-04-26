package com.example.myproject2

import java.lang.IllegalArgumentException

fun main() {
    var myCar = Car()
    println("brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 2
    println("Maxspeed is ${myCar.maxSpeed}")
    println("Model is ${myCar.myModel}");
}

class Car() {
    // lateinit говорит о том, что данная переменная будет инициализирована позже
    lateinit var owner : String
    // пример гетера
    val myBrand: String = "BMW"
    get() {
        return field.toLowerCase()
    }
    var maxSpeed: Int = 250
    get() = field
    set(value) {
        field = if(value > 0) value else throw IllegalArgumentException("Max speed cannot be less than 0")
    }
    var myModel:String = "M5"
    private set // устанавливаем приватным setter
    
    // инициализатор
    init {
        this.myModel = "M3"
        this.owner = "Frank"
    }
}