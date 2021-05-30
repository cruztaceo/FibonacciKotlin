import kotlinx.coroutines.*
import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.math.sqrt
import kotlin.system.exitProcess

suspend fun main() = coroutineScope {
    val n = 30
    val iterative = async {
        println("Fibonacci Iterative:   Nth number: $n, Result = ${fibonacciIterative(n)}")
    }
    val recursive = async {
        println("Fibonacci Recursive:   Nth number: $n, Result = ${fibonacciRecursive(n)}")
    }
    val closedForm = async {
        println("Fibonacci Closed Form: Nth number: $n, Result = ${fibonacciClosedForm(n)}")
    }
    val divideAndConquer = async {
        println("Fibonacci Divide and Conquer: Nth number: $n, Result = ${fibonacciDivideAndConquer(n)}")
    }
    val exponentiation = async {
        println("Exponentiation by Squaring: 2 ^ $n, Result = ${exponentiationBySquaring(2, n)}")
    }

    try {
        withTimeout(3000L){
            iterative.await()
            recursive.await()
            closedForm.await()
            divideAndConquer.await()
            exponentiation.await()
            "Done"
        }
    } catch (e: TimeoutCancellationException){
        exitProcess(1)
    }
    println("Done")

}

fun fibonacciIterative(n: Int): Long {
    var firstNumber = 0L
    var secondNumber = 1L
    var result = 0L

    if (n == 0)
        return 0L
    else if (n == 1)
        return 1L

    for (i in 2..n) {
        result = firstNumber + secondNumber
        firstNumber = secondNumber
        secondNumber = result
    }
    return result
}

fun fibonacciRecursive(n: Int): Long {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

fun fibonacciClosedForm(n: Int): Long {
    if (n == 0) {
        return 0
    } else if (n == 1) {
        return 1
    }
    return ((1 / sqrt(5.0) * ((1 + sqrt(5.0)) / 2).pow(n)) - (1 / sqrt(5.0) * ((1 - sqrt(5.0)) / 2).pow(n))).roundToLong()
}

fun fibonacciDivideAndConquer(n: Int): Long {
    if (n == 0) {
        return 0
    }
    val matrix = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))

    return matrixExponentiation(matrix, n)[0][1]
}

fun matrixExponentiation(inputMatrix: Array<LongArray>, n: Int): Array<LongArray> {
    val matrix = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
    //f(n)  = 0 1 1 2 3 5
    //n     = 0 1 2 3 4 5
    if (n > 1) {
        multiplyMatrix(matrixExponentiation(inputMatrix, n / 2), inputMatrix)

        if (n.mod(2) != 0) {
            multiplyMatrix(inputMatrix, matrix)
        }
    }
    return inputMatrix
}

fun multiplyMatrix(matrixA: Array<LongArray>, matrixB: Array<LongArray>): Array<LongArray> {

    val x0 = (matrixA[0][0] * matrixB[0][0]) + (matrixA[0][1] * matrixB[1][0])
    val x1 = (matrixA[0][0] * matrixB[1][0]) + (matrixA[0][1] * matrixB[1][1])
    val y0 = (matrixA[1][0] * matrixB[0][0]) + (matrixA[1][1] * matrixB[1][0])
    val y1 = (matrixA[1][0] * matrixB[1][0]) + (matrixA[1][1] * matrixB[1][1])

    matrixA[0][0] = x0
    matrixA[0][1] = x1
    matrixA[1][0] = y0
    matrixA[1][1] = y1

    return matrixA
}

fun exponentiationBySquaring(x: Int, n: Int): Int {
    return if (n.mod(2) == 0) {
        x.toDouble().pow(n / 2).pow(2).toInt()
    } else {
        x * x.toDouble().pow(n - 1).toInt()
    }
}