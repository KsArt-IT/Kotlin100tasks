package ru.ksart.consolecalculator

import org.junit.Test
import org.junit.Assert.*

class CalculatorUnitTest {
    @Test
    fun testCalculator() {
        assertEquals(Double.POSITIVE_INFINITY, Calculator.execute("2 5 * 5 / 2"), 0.000001)
        assertEquals(Double.POSITIVE_INFINITY, Calculator.execute(arrayOf("2", "5", "*", "5", "/", "2")), 0.000001)
        assertEquals(22.5, Calculator.execute("2.5 + 4 * 5"), 0.000001)
        assertEquals(14.5, Calculator.execute("2 + 5 * 5 / 2"), 0.000001)
        assertEquals(Double.POSITIVE_INFINITY, Calculator.execute("2 ++ 5 * 5 / 2"), 0.000001)
        assertEquals(7.0, Calculator.execute(2,5, "+"), 0.000001)
    }
}