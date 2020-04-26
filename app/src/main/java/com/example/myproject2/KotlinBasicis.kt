package com.example.myproject2


fun main() {
    var denis = Person("Denis", "Panjuta", 31)
    denis.hobby = "skateboard"
    denis.age = 32
    println("Denis is ${denis.age} years old")
    denis.stateHobby()
    var john = Person()
    john.hobby = "play video games"
    john.stateHobby()
}

class Person(fitstName:String = "John", lastName:String = "Doe") {
    // Member Variable - Properties
    var age:Int? = null
    var hobby :String = "watch Netflix"
    var firstName:String? = null
    init {
        println("$fitstName and $lastName")
    }
    // Member  secondary Constructor
    constructor(firstName:String, lastName:String, age: Int) : this(firstName, lastName) {
        this.age = age
        println("$firstName and $lastName age is $age")
    }
    // Member functions - Methods
    fun stateHobby() {
        this.firstName = "Gleb"
        println("$firstName\'s hobby is $hobby")
    }

}