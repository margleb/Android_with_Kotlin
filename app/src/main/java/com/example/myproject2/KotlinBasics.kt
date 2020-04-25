package com.example.myproject2

fun main() {
    // TODO: Добавить новый функционал
    var myName = "Frank" // тип String
    var myAge = 31 // тип int
    // integer types (принимают номера), можно указать точный тип данный, необходимый мне
    val myByte: Byte = 13
    val myShort: Short = 125
    val myInt: Int = 123123
    val myLong: Long = 12_039_812_309_131_123
    // floating Point number Types: Float (32 bit), Double (64 bit);
    val myFloat: Float = 13.37f;
    val myDouble: Double = 3.32132132133
    // Booleans
    var isSunny: Boolean = true;
    isSunny = false;
    // Char
    val letterChar = 'A'
    val digitChar = '1'
    // String
    val myStr = "Hello World";
    var firstCharInString = myStr[0];
    var lastCharInStr = myStr[myStr.length - 1];
    print("First character " + lastCharInStr);

}