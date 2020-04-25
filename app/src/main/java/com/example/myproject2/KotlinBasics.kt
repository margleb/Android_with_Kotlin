package com.example.myproject2

fun main() {
    // argument
    // var result = addUp(5, 3)
    var avg = avg(5.3, 13.34)
    print("result is $avg")
}

fun avg(a: Double,  b: Double): Double {
    return (a+b)/2
}

// Parameter (input)
fun addUp(a: Int, b: Int) : Int {
    // output
    return a+b
}

fun myFunction() {
    print("Called form myFunction")
}