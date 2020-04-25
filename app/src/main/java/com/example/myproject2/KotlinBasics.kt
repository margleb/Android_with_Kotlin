package com.example.myproject2

fun main() {
    for(num in 1..10) {
        print("$num ")
    }
    println()
    for(i in 1 until 10) {
        print("$i ")
    }
    println()
    // same as - for(i in 10.downTo(1).step(2)
    for(i in 10 downTo 1 step 2) {
        print("$i ")
    }
}