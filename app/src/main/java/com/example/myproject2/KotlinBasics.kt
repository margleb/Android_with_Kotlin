package com.example.myproject2

fun main() {
    var nullabeName:String? = "String"
    nullabeName = null

    // подставляет по умолчанию если null Elvis operator
    val name = nullabeName ?: "Guest"
    println("name is $name")
    // отменяет все защиты по notNull и если нулевой, то выдает ошибку NullPointerException
    nullabeName!!.toLowerCase()

    // операторы можно использовать как цепочка
    // val wifeAge : String? = user?.wife?.age ?: 0

}