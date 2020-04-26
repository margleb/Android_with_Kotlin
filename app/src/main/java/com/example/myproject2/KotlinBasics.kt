package com.example.myproject2

fun main() {
   var name:String = "Denis"
   // name = null
   //  Non-Null тип
   var nullableName:String? = "Denis"
   // nullableName = null

   // var len = name.length
   // var len2 = nullableName?.length
   // println(nullableName?.toLowerCase())
   // Для проведения каких-либо операций исключительно над non-null значениями вы можете использовать let оператор вместе с оператором безопасного вызова
   // it - указывает на этот элемент
   nullableName?.let { println ( it.length )}

   /* if(nullableName!=null) {
       var len2 = nullableName.length
   } else {
       null
   } */
}