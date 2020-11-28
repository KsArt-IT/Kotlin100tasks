import kotlin.math.max
import kotlin.math.min
import kotlin.collections.flatMap as flatMap

fun main() {
    println("Работа с матрицами m x n")
//    val m = readIntNotNull("Введите количество строк m: ", 1)
//    val n = readIntNotNull("Введите количество столбцов n: ", 1)
    val m = 5
    val n = 4
    println("Матрица размером $m x $n")
    // создаем матрицу m на n и заполняем нулями
    val matrix = Array(m) { Array(n) { 0 } }
    // заполняем матрицу
//    for (i in 0..matrix.lastIndex) {
//        for (j in 0..matrix[i].lastIndex) {
//            matrix[i][j] = readIntNotNull("Введите число [$i,$j] = ")
//        }
//    /
    matrix[0] = arrayOf(10, 20, 30, 41)
    matrix[1] = arrayOf(12, 25, 3, 4)
    matrix[2] = arrayOf(0, 2, 34, 45)
    matrix[3] = arrayOf(11, 24, 37, -39)
    matrix[4] = arrayOf(-13, 5, 7, 49)
    // выводим матрицу
    for (row in matrix) {
        for (cell in row) {
            print("$cell \t")
        }
        println()
    }
    // сумму элементов главной диагонали
    var sumMD1 = 0
    for (i in 0 until min(m, n)) {
        sumMD1 += matrix[i][i]
    }
    var sumMD2 = 0
    repeat(min(m, n)) {
        sumMD2 += matrix[it][it]
    }
//    val sumMD = matrix.mapIndexed { index1, ints -> ints.filterIndexed { index, _ -> index == index1 }.first() }.sum()
    val sumMD = matrix.mapIndexed { index, ints -> if (index < ints.size) ints[index] else 0 }.sum()
    println("Сумма элементов главной диагонали: $sumMD, $sumMD1, $sumMD2")
    // среднее арифметическое элементов матрицы
    var average2 = 0.0
    for (row in matrix) {
        for (cell in row) average2 += cell
    }
    average2 /= m * n
    val average = matrix.flatten().average()
    println("average: $average, $average2")
    // среднее арифметическое каждого из столбцов;
    var listAverage = IntArray(n) { 0 }
    for (j in 0 until n) {
        for (i in 0 until m) listAverage[j] += matrix[i][j]
    }
    for (j in 0 until n step 2) {
        listAverage[j] /= m
    }
    listAverage.forEachIndexed { index, i ->
        println("$index: $i")
    }
    // среднее арифметическое каждого из столбцов, имеющих четные номера;
    val listAverage2 = IntArray(n) { 0 }
    for (j in 0 until n step 2) {
        for (i in 0 until m) listAverage2[j] += matrix[i][j]
    }
    for (j in 0 until n step 2) {
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
    val mMin2 = matrix.flatten().min()
    val mMax2 = matrix.flatten().max()
    println("min: $mMin1, $mMin, $mMin2")
    println("max: $mMax1, $mMax, $mMax2")
    // сумму элементов 1-го столбца матрицы;
    val sumM1 = matrix.sumBy {
        it.first()
    }
    var sumM12 = 0
    for (i in 0 until m) sumM12 += matrix[i][0]
    println("сумму элементов 1-го столбца матрицы: $sumM1, $sumM12")
    // сумму элементов строки, в которой расположен наименьший элемент матрицы (предполагается, что он единственный)
    val sumMin = matrix.find {
        it.min() == matrix.flatten().min()
    }?.sum()
    println("сумма элементов строки, в которой расположен наименьший элемент матрицы: $sumMin")
    // значение наибольшего по модулю элемента матрицы
    val maxMod = matrix.flatten().map {
        if (it < 0) -it else it
    }.max()
    println("значение наибольшего по модулю элемента матрицы: $maxMod")
    //сумму наибольших значений элементов ее строк
    val sumMax = matrix.map {
        it.max() ?: 0
    }.sum()
    println("сумму наибольших значений элементов ее строк: $sumMax")
    // наибольшее из значений элементов k-ой строки
    val k = max(0, matrix.size - 2)
    val maxK = matrix[k].max()
    println("наибольшее из значений элементов k-ой строки: $k->$maxK")
    // число отрицательных элементов в k-ой строке
    val countNegative = matrix[k].count {
        it < 0
    }
    println("число отрицательных элементов в k-ой строке: $k->$countNegative")
    // произведение всех элементов матрицы
    var times = 1L
    var countTimes = 0
    matrix.flatten().filter { it != 0 }.forEach {
        times *= it
        countTimes++
    }
    println("произведение всех элементов матрицы: ${if (countTimes > 0) times else 0}")
    //  произведение квадратов тех элементов k-ой строки, которые больше 1, но меньше 3
    var timesK = 1L
    var countTimesK = 0
    matrix[k].filter { it == 2 }.forEach {
        timesK *= it * it
        countTimesK++
    }
    println(" произведение квадратов тех элементов k-ой строки, которые больше 1, но меньше 3: ${if (countTimesK > 0) timesK else 0}")
    // произведение модулей элементов k-ой строки
    var timesMod = 1L
    var countTimesMod = 0
    matrix[k].filter { it != 0 }.forEach {
        timesMod *= if (it < 0) -it else it
        countTimesMod++
    }
    println("произведение модулей элементов k-ой строки: ${if (countTimesMod > 0) timesMod else 0}")
    // заменить элементы главной диагонали на 1
    println("заменить элементы главной диагонали на 1")
    var matrix1 = matrix.copyOf()
    matrix1.mapIndexed { index, ints -> if (index < ints.size) ints[index] = 1 }
    // выводим матрицу
    for (row in matrix1) {
        for (cell in row) {
            print("$cell \t")
        }
        println()
    }
    // заменить все отрицательные элементы матрицы на 0, а положительные элементы матрицы на 1
    println("заменить все отрицательные элементы матрицы на 0, а положительные элементы матрицы на 1")
    val matrix2 = matrix.map { row ->
        row.map {
            if (it < 0) 0 else 1
        }
    }
    // выводим матрицу
    for (row in matrix2) {
        for (cell in row) {
            print("$cell \t")
        }
        println()
    }
    // заменить элементы главной диагонали на 1, а все остальные элементы на 0
    println("заменить элементы главной диагонали на 1, а все остальные элементы на 0")
    var matrix3 = matrix.copyOf()
    matrix3.mapIndexed { index, ints ->
        (0..ints.lastIndex).forEach {
            ints[it] = 0
        }
        if (index < ints.size) ints[index] = 1
    }
    // выводим матрицу
    for (row in matrix3) {
        for (cell in row) {
            print("$cell \t")
        }
        println()
    }

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
