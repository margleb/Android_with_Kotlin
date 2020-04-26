package com.example.myproject2


fun main() {
    var audiA3 = Car(200.0, "A3", "Audi")
    var teslaS = ElectricCar(240.0,"S-model", "Tesla", 85.0)
    teslaS.chargerType = "Type2"
    // teslaS.extendRange(200.0)

    // teslaS.drive()
    teslaS.breake()
    audiA3.breake()

    // Polymorphism
    // audiA3.drive(200.0)
    // teslaS.drive(200.0)
}


interface Drivable {
    val maxSpeed: Double
    fun drive():String
    fun drive(distance:Double):String
    fun breake() { // можно указать по умолчанию
        println("The drivable is breaking")
    }
}

// расширяем интерфейсом Drivable, а также добавляем поле, необходимое для перезаписи
open class Car(override val maxSpeed: Double, val name:String, val brand:String) : Drivable {
    open var range: Double = 0.0
    // перезаписанный метод
    override fun drive(distance: Double): String = "Drove for $distance KM on regularCar"

    fun extendRange(amount: Double) {
        if(amount > 0) {
            range += amount
        }
    }

    // перезаписанный метод
    override fun drive(): String = "driving the interface drive"
}

// так как в интерфейс был включен в родительский класс, то здесь тоже нужно расширить
class ElectricCar(maxSpeed: Double, name: String, brand:String, batteryLife: Double) : Car(maxSpeed,name, brand) {
    var chargerType = "Type1"
    override var range = batteryLife * 6

    // перезаписанный метод
    override fun drive(distance: Double): String = "Drove for $distance KM on electricity"

    // допускается такой же вариант перезаписи
    override fun drive(): String {
        return "Drove for $range КM on electircity"
    }
    override fun breake() {
        super.breake()
        println("breake inside of electric car")
    }
}