import kotlin.math.min

fun main() {
    println("Работа с матрицами m x n")
    val m = readIntNotNull("Введите количество строк m: ", 1)
    val n = readIntNotNull("Введите длину строки n: ", 1)
    println("Матрица размером $m x $n")
    // создаем матрицу m на n и заполняем нулями
    val matrix = Array(m) { IntArray(n) { 0 } }
    // заполняем матрицу
    for (i in 0..matrix.lastIndex) {
        for (j in 0..matrix[i].lastIndex) {
            matrix[i][j] = readIntNotNull("Введите число [$i,$j] = ")
        }
    }
    // выводим матрицу
    for (row in matrix) {
        for (cell in row) {
            print("$cell \t")
        }
        println()
    }
    // сумму элементов главной диагонали
    var sumMD = 0
    for (i in 0..min(m, n)) {
        sumMD += matrix[i][i]
    }
    var sumMD1 = 0
    repeat(min(m, n)) {
        sumMD1 += matrix[it][it]
    }
    println("Сумма элементов главной диагонали: $sumMD, $sumMD1")
    // среднее арифметическое элементов матрицы
    val average1 = matrix.flatMap { row ->
        row.map {
            it
        }
    }.toList().average()
    var average2 = 0.0
    for (row in matrix) {
        for (cell in row) average2 += cell
    }
    average2 /= m * n
    println("average: $average1, $average2")
    // среднее арифметическое каждого из столбцов;
    var listAverage = IntArray(n) { 0 }
    for (j in 0..n) {
        for (i in 0..m) listAverage[j] += matrix[i][j]
    }
    for (j in 0..n step 2) {
        listAverage[j] /= m
    }
    listAverage.forEachIndexed { index, i ->
        println("$index: $i")
    }
    // среднее арифметическое каждого из столбцов, имеющих четные номера;
    val listAverage2 = IntArray(n) { 0 }
    for (j in 0..n step 2) {
        for (i in 0..m) listAverage2[j] += matrix[i][j]
    }
    for (j in 0..n step 2) {
        listAverage2[j] /= m
    }
    listAverage2.forEachIndexed { index, i ->
        if (index % 2 == 0) println("$index: $i")
    }
    // наибольший (наименьший) элемент матрицы;
    val mMin1 = matrix.flatMap { row ->
        row.map { it }
    }.toList().min()
    val mMax1 = matrix.flatMap { row ->
        row.map { it }
    }.toList().max()
    var mMin = matrix[0][0]
    var mMax = matrix[0][0]
    for (row in matrix) {
        for (cell in row) {
            if (mMin > cell) mMin = cell
            if (mMax < cell) mMax = cell
        }
    }
    println("min: $mMin1, $mMin")
    println("max: $mMax1, $mMax")

}

tailrec fun readIntNotNull(message: String, moreThanInt: Int? = null): Int {
    print(message)
    val result = readLine()?.toIntOrNull()
    return if (result != null && (moreThanInt == null || result > moreThanInt)) {
        result
    } else {
        readIntNotNull(message, moreThanInt)
    }
}
