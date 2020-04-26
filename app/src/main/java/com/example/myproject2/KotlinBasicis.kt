package com.example.myproject2

// класс для хранения данных
// основной конструктор имеет как минимум один параметр
// параметры конструктора должны быть как val или var
// классы данных не могут быть абстрактными, open, sealed или inner
data class User(val id: Long, var name: String)

fun main() {
    val user1 = User(1, "Denis")
    //val name = user1.name
    //println(name)
    //user1.name = "Michael"

    val user2 = User(2, "Michael")

    // так как это класс данных, то тут уже есть по умолчанию методы:
    // equels()/hashCode()
    // println(user1.equals(user2))
    // toString()
    // println("User Details: $user1")
    // сopy()
    val updatedUser = user1.copy(name="Denis Panjuta")

    // println(user1)
    // println(updatedUser)

    // компонентная функция, позволяющая распечатать значение компоненты
    // println(updatedUser.component1()) // print 1
    // println(updatedUser.component2()) // print Denis Panjuta

    // сохранение в разные переменные значение полей
    val(id, name) = updatedUser
    println("id=$id, name=$name")
}