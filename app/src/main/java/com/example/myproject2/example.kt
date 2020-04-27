package com.example.myproject2

fun main() {
    // Иногда невозможно скастить переменну и она выбрасывает исключение, это называется "небезопасный кастинг"
    var epic: Any? = null;
    // безопасный кастинг
    var str:String? = epic as? String
    // небезопасный кастинг
    // var str:String = epic as String
    println(str)
}