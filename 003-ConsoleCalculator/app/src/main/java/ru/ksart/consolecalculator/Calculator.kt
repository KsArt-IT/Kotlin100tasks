package ru.ksart.consolecalculator

import java.lang.Exception

object Calculator {
    private val EXIT = arrayOf("q", "e", "quit", "exit")
    private val CLEAR = arrayOf("c", "C")
    private val regex = "\\${CalculatorOperation.values().joinToString("\\") { it.operation }}"
    private val REGEX = """(?<=[$regex])|(?=[$regex])""".toRegex()

    // получение оерации CalculatorOperation из значения строки
    private fun getOperationFromString(operation: String): CalculatorOperation? =
        CalculatorOperation.values().find { it.isOperation(operation) }

    // проверка является введенная операция корректной
    private fun isOperationFromString(operation: String) =
        getOperationFromString(operation) != null

    // получить приоритет операции
    private fun getPriorityOperation(operation: String): Int =
        getOperationFromString(operation)?.priority
        ?: throw Exception("Ошибка приоритета операции")

    // рекурсивное вычисление значения выражения
    private fun calculate(expression: List<String>, iterator: Iterator<Int>): List<String> =
        if (!iterator.hasNext()) expression
        else {
            val list = mutableListOf<String>()
            val priority = iterator.next()
            var i = 0
            var operation: CalculatorOperation?
            while (i < expression.size) {
                operation = getOperationFromString(expression[i])
                if (operation == null || operation.priority != priority) {
                    list.add(expression[i++])
                } else {
                    i++
                    val x = list[list.lastIndex].toDoubleOrNull() ?: throw CalculatorExit()
                    val y =  expression[i++].toDoubleOrNull() ?: throw CalculatorExit()
                    val result = operation.execute(x, y)
                    list[list.lastIndex] = result.toString()
                }
            }
            calculate(list, iterator)
        }

    // проверка выражения на правильный порядок операций и отсутствие дублирования
    private fun isOrderOperations(expression: List<String>): Boolean {
        if (expression.size < 3 || expression.size % 2 == 0) return false
        var isOperation = !isOperationFromString(expression[0])
        for (element in expression) {
            if (element.isBlank()) return false
            isOperation = if (isOperation != isOperationFromString(element)) !isOperation else return false
        }
        return true
    }

    // вычисление выражения
    private fun calculateExpression(expression: List<String>): Double =
        try {
            // проверка выражения на корректность
            if (expression.isEmpty() || !isOrderOperations(expression)) throw Exception("Ошибка выражения")
            // получаем список уникальных приоритетов операций в отсортированном виде
            val listPriority = expression.filter { getOperationFromString(it) != null }.map { getPriorityOperation(it) }.toSortedSet()
            // рекурсивно с перебором приоритетов операций подсчитываем значение выражения
            calculate(expression, listPriority.iterator())
                .first().toDoubleOrNull()
                ?: throw Exception("Ошибка подсчета выражения")
        } catch (ignore: Exception) {
            Double.POSITIVE_INFINITY
        }

    // обычный калькулятор
    private fun calculateCommon() {
        println("Калькулятор обыкновенный")
        println("Операции: +,-,*,/,^,c-очистить,q-выход")
        var result: Double = 0.0 //первое число
        try {
            // ввести первое число
            result = inputNumber()
            while (true) {
                try {
                    // ввести операцию и другое число и вычислить результат
                    result = inputOperation().execute(result, inputNumber())
                    println("= ${if ((result - result.toInt()) == 0.0) result.toInt() else result}")
                } catch (e: CalculatorClear) {
                    // очистка
                    println("------------------")
                    result = inputNumber()
                }
            }
        } catch (e: CalculatorExit) {
            // выход из калькулятора
            return
        } catch (e: Exception) {
            // ошибка
            println("Произошла ошибка.")
        } finally {
            println("Пока!")
        }
    }

    // вводим число в цикле, пока не будет введено число или команда
    private fun inputNumber(): Double {
        var number: Double = Double.NEGATIVE_INFINITY
        while (number == Double.NEGATIVE_INFINITY) {
            print("Введите число: ")
            val input = readLine() ?: continue
            if (input.toLowerCase() in EXIT) throw CalculatorExit()
            if (input in CLEAR) throw CalculatorClear()
            number = input.toDoubleOrNull() ?: continue
        }
        return number
    }

    // вводим операцию в цикле, пока не будет введена правильная операция или команда
    private fun inputOperation(): CalculatorOperation {
        var operation: CalculatorOperation? = null
        while (operation == null) {
            print("Введите операцию: ")
            val input = readLine() ?: continue
            if (input.toLowerCase() in EXIT) throw CalculatorExit()
            if (input in CLEAR) throw CalculatorClear()
            operation = getOperationFromString(input)
        }
        return operation
    }

    // выполнить для строки
    fun execute(expresion: String): Double =
        if (expresion.isNotBlank()) {
            val listExpresion = expresion.split(REGEX)
            val result = calculateExpression(expresion.split(REGEX))
            println("${listExpresion.joinToString(" ")} = ${if (result - result.toInt() <= 0.000001) result.toInt() else result}")
            result
        }
        else 0.0

    // выполнить для аргументов командной строки
    fun execute(args: Array<String>): Double =
        if (args.isNotEmpty()) execute(args.joinToString(" "))
        else {
            calculateCommon()
            0.0
        }

    // выполнить для операции
    fun <T: Number> execute(x: T, y: T, operation: String): Double {
        val operat = getOperationFromString(operation) ?: return Double.POSITIVE_INFINITY
        return operat.execute(x.toDouble(), y.toDouble())
    }
}