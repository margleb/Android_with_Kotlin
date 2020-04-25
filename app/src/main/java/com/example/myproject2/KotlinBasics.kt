package com.example.myproject2

fun main() {
    //Assign operators(+=,-=,*=,/=,%=0)
    var myNum = 5
    myNum += 3
    println("myNum is $myNum")
    myNum *= 4
    println("myNum is $myNum")
    // Increment/Decrement
    myNum++
    println("myNum is $myNum")
    myNum--
    println("myNum is $myNum")
    println("myNum is ${myNum++}")
    println("myNum is ${++myNum}")
}