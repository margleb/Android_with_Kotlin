package com.example.myproject2

fun main() {
    var denis  = Person("Gleb", "Martianov")
    var john = Person()
    var johnPeterson = Person(lastName = "Peterson")
}

class Person(firstName: String = "John", lastName: String = "Doe") {
    // Initializer Block
    init {
        println("Person created $firstName $lastName")
    }
}