package com.example.myproject2
// В kotlin предусмотрено 4 модификтаора доступа private/protected/internal/public

fun main() {
    // Если явно не используется никакого модификатора, то он по умолчанию применяется как public
}

// Если явно не используется никакого модификатора, то он по умолчанию применяется как public
class PublicVisible(name:String) {
    init {
        println("Hello $name this class has public access")
    }
}
// Видин только внутри класса example
private class PrivateVisible {
    fun isPrivate() {
        println("You can't have a access becouse it private")
    }
}

// модификатор protected не приминем внутри файла (топлевел уровень)
// protected class ProtectedVisible {}

// Доступно только в модуле, каком то наборе файлов maven/groovy и так далее
internal class InternalVisible {
    init {
        println("This class has a internal access, that's mean have access only at same module")
    }
}

