package ru.ksart.tryandcatch

fun main(args: Array<String>) {
    println("Kotlin - работа с исключениями.")
    var num: Int? = try {
        args[0].toIntOrNull()
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Вызвано исключение ${e.javaClass.simpleName} (${e.message})")
        null
    }
    println("Исключение перехвачено и программа дальше работает!")
    var num1: Int = try {
        num!!
    } catch (e: NullPointerException) {
        println("Вызвано исключение ${e.javaClass.simpleName} (${e.message})")
        0
    }
    println("Исключение перехвачено и программа дальше работает!")
    val num2: Int = try {
        0 / num1
    } catch (e: ArithmeticException) {
        println("Вызвано исключение ${e.javaClass.simpleName} (${e.message})")
        0
    }
    println("Исключение перехвачено и программа дальше работает!")
    try {
        throw ClassCastException()
    } catch (e: ClassCastException) {
        println("Вызвано исключение ${e.javaClass.simpleName} (${e.message})")
    }
    println("Исключение перехвачено и программа дальше работает!")
    try {
        throw Exception()
    } catch (e: Exception) {
        println("Вызвано исключение ${e.javaClass.simpleName} (${e.message})")
    }
    println("Исключение перехвачено и программа дальше работает!")
    try {
        throw NumberFormatException()
    } catch (e: NumberFormatException) {
        println("Вызвано исключение ${e.javaClass.simpleName} (${e.message})")
    }
    println("Исключение перехвачено и программа дальше работает!")
}
/*
Что можно в Kotlin
С точки зрения исключений компилятор Kotlin отличается тем, что:
1. Не различает checked и unchecked исключения. Все исключения – только unchecked, и вы самостоятельно принимаете решение, стоит ли их отлавливать и обрабатывать.

2. Try можно использовать как выражение – можно запустить блок try и либо вернуть из него последнюю строчку, либо вернуть последнюю строчку из блока catch.
val value = try {Integer.parseInt(“null”)}
catch(e: NumberFormanException) { 4 }

3. А также можно использовать подобную конструкцию при обращении к какому-либо объекту, который может быть nullable:

val s = obj.money
        ?: throw IllegalArgumentException(“Где деньги, Билли?”)
*/
