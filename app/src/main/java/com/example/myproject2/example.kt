package com.example.myproject2


var total = 0.0
val arrayList = ArrayList<Double>()

fun main() {
    totalCount()
    average()
}

fun totalCount() {
    arrayList.add(1.5)
    arrayList.add(2.5)
    arrayList.add(3.3)
    for(list in arrayList) {
        total += list
    }
}

fun average() : Double {
    val average = total / arrayList.size
    println(average)
    return average
}

