package ru.ksart.kotlintypes

fun main() {
    println("========================================================")
    println("-----------= Kotlin v1.3 Basic Types =------------------")
    println("https://kotlinlang.org/docs/reference/basic-types.html")
    println("========================================================")
    println("Родитель всех классов - Any")
    println("Any - не нулабельный тип, Any? - нулабельный тип = null")
    println("--------------------------------------------------------")
    println("Числа:")
    println("Представление: 10 - , 16 - 0x0F, 8 - отсутствуе, 0b - 2")
    println("Наследование: Number -> Any, Number -> Number? -> Any?")
    println("Каждое число поддерживает только явное преобразование: ")
    println("toByte(): Byte; toShort(): Short; toInt(): Int; toLong(): Long;")
    println("toFloat(): Float; toDouble(): Double; toChar(): Char")
    println("--------------------------------------------------------")
    println("Byte (8 bit) -> Number, Byte -> Byte? -> Number?")
    println("min = ${Byte.MIN_VALUE} max = ${Byte.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("Short (16 bit) - > Number, Short -> Short? -> Number?")
    println("min = ${Short.MIN_VALUE} max = ${Short.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("Int (32 bit) - > Number, Int -> Int? -> Number?")
    println("min = ${Int.MIN_VALUE} max = ${Int.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("Long (64 bit) - > Number, Long -> Long? -> Number?")
    println("suffix L - пример: val numLong = 1L")
    println("min = ${Long.MIN_VALUE} max = ${Long.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("Float (32 bit) - > Number, Float -> Float? -> Number?")
    println("suffix f или F - пример: val numFloat = 1f")
    println("min = ${Float.MIN_VALUE} max = ${Float.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("Double (64 bit) - > Number, Double -> Double? -> Number?")
    println("min = ${Double.MIN_VALUE} max = ${Double.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("Unsigned integers:")
    println("suffix U или u - пример: val num = 1u")
    println("--------------------------------------------------------")
    println("UByte (8 bit) -> UByte?")
    println("min = ${UByte.MIN_VALUE} max = ${UByte.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("UShort (8 bit) -> UShort?")
    println("min = ${UShort.MIN_VALUE} max = ${UShort.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("UInt (8 bit) -> UInt?")
    println("min = ${UInt.MIN_VALUE} max = ${UInt.MAX_VALUE}")
    println("--------------------------------------------------------")
    println("ULong (64 bit) -> ULong?")
    println("min = ${ULong.MIN_VALUE} max = ${ULong.MAX_VALUE}")
    println("========================================================")
    println("Char - символ, не цифра, пример: val char: Char = 'a'")
    println("--------------------------------------------------------")
    println("String - строка, пример: val str: String = \"string\"")
    println("========================================================")
    println("Boolean - Логический тип true, false")
    println("Пример: val bool = false")
    println("Встроенные действия над логическими переменными включают:")
    println("|| – ленивое логическое ИЛИ; && – ленивое логическое И;")
    println("! - отрицание")
    println("========================================================")
    println("Unit - возвращаемое единичное значение (void)")
    println("Unit -> Any, Unit? -> Any?")
    println("--------------------------------------------------------")
    println("Nothing - ничего - возвращаемое пустое, дальше не выполняется")
    println("Nothing ->...-> Any, Nothing? ->..-> Any?")
    println("========================================================")
}
/*
Any, Boolean, Byte, Char, Short, Int, Long, Float, Double, String, Unit, Nothing и
Any? Boolean? Byte? Char? Short? Int? Long? Float? Double? String? Nothing?
UByte UShort UInt ULong
Unsigned integers
Double 	64
Float 	32
Long 	64
Int 	32
Short 	16
Byte 	8
*/
