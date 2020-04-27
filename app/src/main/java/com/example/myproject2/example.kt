package com.example.myproject2

fun main() {
    addNumber(5, 10)
    println(sum(5, 10))
    println(sumShoter(10, 6))
}

// cоздаем лямбда функцию, называемую sum, берем 2 параметра Int, возращаем Int
// теперь, мы говорим что a типа int + b типа int равно a+b
val sum:(Int,Int) -> Int = {a:Int,b:Int->a+b}
// более короткая запись
val sumShoter = {a:Int, b:Int -> println(a+b)}

fun addNumber(a:Int, b:Int) {
    println(a + b)
}