package com.example.myproject2

class Fruit {
    private var watermelon: String = "watermelon"
    private var grapes: String = "grapes"
    private var greenApple: String = "greenApple"
    // Вложенный класс это класс который создан внутри другого класса
    // В Котлине вложенный класс по умолчанию статический, поэтому доступ к членам класса может быть получить без сощдания обьекта данного класса
    // Вложенные классы не могут иметь доступ до переменых членов внешнего класса
    class Nested {
        fun sayHello() {
            // нельзя получить доступ до переменных
            // println("$watermelon + $grapes + $greenApple")
        }
    }
    // Внутренний класс - это класс который создает внутри другого класса с ключевым словом inner
    // Внутренний класс не может быть облевлен внутри интерфейся или не внутрненнего вложенного класса
    // Приемущество внутреннего класса перед вложенным классом то, что они может иметь доступ до члено внешнего класса, даже если они обьявлены приватными
    // Внутренник классы содержат ссылку на обьект их внешнего класса
    inner class Inner {
        fun getAppleEmoji():String {
            println("I am a function inside a INNER class")
            println("apple emoji is $greenApple")
            return greenApple
        }
    }
}

fun main(args: Array<String>) {
    Fruit.Nested().sayHello()
    // необходимо инициализировать перед тем, как получать данные до внутреннего класса
    var fruit = Fruit()
    fruit.Inner().getAppleEmoji();
}