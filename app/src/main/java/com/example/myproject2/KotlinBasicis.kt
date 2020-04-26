package com.example.myproject2

fun main() {
    val human = Human("Dengis", "Russia", 70.0, 28.0)
    val elephant = Elephant("Rosy", "India", 5400.0, 25.0)
    // val mammal = Mammal("Denis", "Russia", 70.0, 28.0) // нельзя создать из абстрактного класса обьект
    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
}

    // Главное отличие интерфейсов от абстрактных классов заключается в невозможности хранения переменных экземпляров
    // Абстрактный класс не может быть инициализирован (из него нельзя создать обьект)
    // Однако, я могу наследовать собклассы из абстрактного класса
    // Члены (свойства и методы) абстрактного класса не абстрактные
    // Интерфейсы в отличие от абстрактных классов не имею конструктора
    // тем не менее я могу явно указать abstract ключевое слово, для того чтобы их сделать абстрактными
    abstract class Mammal(private val name:String, private val origin:String, private val weight:Double) { // не абстрактные свойства
        // абстрактное свойство (должно быть переписано собклассом)
        abstract var maxSpeed: Double
        // абстрактное свойство (должно быть реализовано с помочью собкласса)
        abstract fun run()
        abstract fun breath()
        // не абстрактный класс
        fun displayDetails() {
            println("Name: $name, Origin: $origin, Weight: $weight, " + "Max Speed: $maxSpeed")
        }
    }

    // Класс наследуемы от Mammal
    class Human(name:String, origin:String, weight:Double, override var maxSpeed:Double): Mammal(name, origin, weight) {
        override fun run() {
            // Code to run
            println("Runs on two legs")
        }
        override fun breath() {
            // Code to breath
            println("Breath through mouth or nose")
        }
    }
    class Elephant(name:String, origin:String, weight:Double, override var maxSpeed:Double):Mammal(name, origin, weight) {
        override fun run() {
           // Code to run
           println("Runs on four legs")
        }

        override fun breath() {
            // Code to breath
            println("Breath through the trunk")
        }
    }