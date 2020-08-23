package ru.ksart.consolecalculator

import kotlin.math.pow

enum class CalculatorOperation(
    val operation: String,
    val priority: Int,
    val execute: (Double, Double) -> Double
) {
    PLUS("+", 3, { x, y -> x + y }),
    MINUS("-", 3, { x, y -> x - y }),
    TIMES("*", 2, { x, y -> x * y }),
    DIVIDED("/", 2, { x, y -> x / y }),
    POW("^", 1, { x, y -> if (y == 2.0) x * x else x.pow(y) });

    fun isOperation(operation: String) = this.operation == operation
}