import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val n = 6
    println("Fibonacci Iterative:   Nth number: $n, Result = ${fibonacciIterative(n)}")
    println("Fibonacci Recursive:   Nth number: $n, Result = ${fibonacciRecursive(n)}")
    println("Fibonacci Closed Form: Nth number: $n, Result = ${fibonacciClosedForm(n)}")
    println("Fibonacci Divide and Conquer: Nth number: $n, Result = ${fibonacciDivideAndConquer(n)}")
    println("Fibonacci Exponentiation: Nth number: $n, Result = ${exponentiationBySquaring(2, n)}")
}

fun fibonacciIterative(n: Int): Int {
    var firstNumber = 0
    var secondNumber = 1
    var result = 0

    for (i in 2..n) {
        result = firstNumber + secondNumber
        firstNumber = secondNumber
        secondNumber = result
    }
    return result
}

fun fibonacciRecursive(n: Int): Int {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

fun fibonacciClosedForm(n: Int): Int {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    }
    return ((1 / sqrt(5.0) * ((1 + sqrt(5.0)) / 2).pow(n)) - (1 / sqrt(5.0) * ((1 - sqrt(5.0)) / 2).pow(n))).toInt()
}

fun fibonacciDivideAndConquer(n: Int): Int {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    }
    val matrix = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))

    return matrixExponentiation(matrix, n)[0][1]
}

fun matrixExponentiation(res: Array<IntArray>, n: Int): Array<IntArray>{
    val matrix = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
    //f(n)  = 0 1 1 2 3 5
    //n     = 0 1 2 3 4 5

    val x0 = (res[0][0] * matrix[0][0]) + (res[0][1] * matrix[1][0])
    val x1 = (res[0][0] * matrix[1][0]) + (res[0][1] * matrix[1][1])
    val y0 = (res[1][0] * matrix[0][0]) + (res[1][1] * matrix[1][0])
    val y1 = (res[1][0] * matrix[1][0]) + (res[1][1] * matrix[1][1])

    res[0][0] = x0;
    res[0][1] = x1;
    res[1][0] = y0;
    res[1][1] = y1;

    if(n > 2)
        return matrixExponentiation(res, n - 1)

    return res
}

fun fibonacciDivideAndConquerv1(n: Int): Int {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    }
    //{\displaystyle (-1)^{n}=F_{n+1}F_{n-1}-F_{n}^{2}.}
    val res = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
    //f = first row, second column
    //  1   1   |   00  01
    //  1   0   |   10  11
    // =======
    for (i in 2..n) {
        val x0 = res[0][0] + res[1][0]
        val x1 = res[0][0]
        val y0 = res[1][0] + res[1][1]
        val y1 = res[1][0]

        res[0][0] = x0;
        res[0][1] = x1;
        res[1][0] = y0;
        res[1][1] = y1;

        println("fn+1 = $x0, fn = $x1 | $y0, fn-1 = $y1")
    }
    return res[0][1]
}

fun exponentiationBySquaring(x: Int, n: Int): Int {
    return if (n.mod(2) == 0) {
        x.toDouble().pow(n / 2).pow(2).toInt()
    } else {
        x * x.toDouble().pow(n - 1).toInt()
    }
}