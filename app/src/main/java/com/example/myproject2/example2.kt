package com.example.myproject2


class TestClass {
    fun testing() {
        var person = Person()
        print(person.d)
        print(person.c)
        // print(person.a) // приватно по своей природе
        // print(person.b) // доступно только в собклассах!!
    }
}

// Super Class
open class Person {
    private val a = 1
    protected val b = 2
    internal val c = 3
    val d = 10 // публична по своей природе, поэтому обьявление не требуется
}

// Derived Class or Sub Class
class Indian: Person() {
    // a is not visible
    // b, c, d is visible

    fun test() {
        println("$b, $c, $d")
        // println($a) // недоступно, так как приватно
    }
}