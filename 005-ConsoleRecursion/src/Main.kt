fun main() {
    var x = 5
    println("-----Фибоначчи-----")
    print("fibonacci(x) = ")
    println(" = ${fibonacci(x)}")
    x = -6
    print("fibonacci(x) = ")
    println(" = ${fibonacci(x)}")
    println("-----Факториал-----")
    x = 5
    println("$x! = ${factorial(x)}")
    x = 5
    println("$x! = ${factorial(x.toLong())}")
}

private tailrec fun factorial(x: Long, n: Long = 1): Long =
    if (x == 0L || x == 1L) n
    else factorial(x - 1L, n * x)

/*
под капотом вызывается
   private static final long factorial(long x, long n) {
      while(x != 0L && x != 1L) {
         long var10000 = x - 1L;
         n *= x;
         x = var10000;
      }

      return n;
   }
 */
private fun factorial(x: Int): Int =
    if (x == 0 || x == 1) 1
    else x * factorial(x - 1)

/*
под капотом вызывается
   private static final int factorial(int x) {
      return x != 0 && x != 1 ? x * factorial(x - 1) : 1;
   }
 */
private fun fibonacci(x: Int): Int {
    return when (x) {
        -2 -> (-1).apply { print('1') }
        0 -> (0).apply(::print)
        -1, 1, 2 -> (1).apply(::print)
        else -> {
            if (x > 0) {
                prn0('(') + fibonacci(x - 2) + prn0('+') + fibonacci(x - 1) + prn0(')')
            } else {
                prn0('(') + fibonacci(x + 2) + prn0('-') - fibonacci(x + 1) + prn0(')')
            }
        }
    }
}

private fun prn0(chr: Char): Int {
    print(chr)
    return 0
}
