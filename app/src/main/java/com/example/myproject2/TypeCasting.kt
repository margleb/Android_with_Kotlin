package com.example.myproject2

import java.lang.Math.floor

fun main() {
    val stringList: List<String> = listOf("Denis", "Frank", "Michael", "Garry")
    val mixedTypeList: List<Any> = listOf("Denis", 31, 5, "BDay", 70.5, "weighs", "Kg")
    for(value in mixedTypeList) {
        if(value is Int) {
            println("Integer: '$value'")
        } else if(value is Double) {
            println("Double: '$value' with Floor value ${floor(value)}")
        } else if(value is String) {
            println("String: '$value' of length ${value.length}")
        } else {
            println("Unknown Type")
        }
    }
    for(value in mixedTypeList) {
        when(value) {
            is Int -> println("Integer: $value")
            is Double -> println("Double: $value with Floor value ${Math.floor(value)}")
            is String -> println("String: $value of length ${value.length}")
            else -> println("Unknown Type")
        }
    }

    // SMART CAST
    val obj1: Any = "I have a dream"
    if(obj1 !is String) {
        println("Not is String")
    } else {
        // obj is authomatically cast to a String in this scope
        println("Found a String of length ${obj1.length}")
    }

    // Явной (небезопасный) кастинг с использование ключевого слово "as" - может привести к проблемам
    // сработает, eсли obj1 является cтринговым значением
    val str1:String=obj1 as String
    println(str1.length)

    val obj2:Any = 1337
    // val str2:String = obj2 as String
    // println(str2)

    // Явный(безопаный) кастин с использованием ключевого слово "as?"
    val obj3:Any = 1337
    val str3:String? = obj3 as? String // Works
    println(str3)

}