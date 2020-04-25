package com.example.myproject2

fun main() {
    var season = 3
    // аналог switch
    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Authumn")
        }
        4 -> println("Winter")
        else -> println("Invalid Season") // default block
    }
    var month = 3
    // c диапазонами
    when(month){
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        // in 12 downTo 2 -> println("Winter")
        else -> println("Invalid Season") // default block
    }
    val age = 15;
    when(age) {
        !in 0..20 -> println("now you may drink in ther US")
        in 18..20 -> println("you may vote now")
        16,17 -> println("you may drive now")
        else -> println("you too young")
    }
    // any означает может быть любого типа
    var x : Any = 13.37f
    // is проверяет является ли типом
    when(x) {
        is Int -> println("$x is an Int")
        is Double -> println("$x is a double")
        is String -> println("$x is a String")
        else -> println("$x is none of the above")
    }
}