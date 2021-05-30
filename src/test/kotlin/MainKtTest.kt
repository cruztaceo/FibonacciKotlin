import org.junit.Test
import kotlin.test.assertEquals

internal class MainKtTest {

    @Test
    fun fibonacciIterativeNth0() {
        assertEquals(0, fibonacciIterative(0))
    }

    @Test
    fun fibonacciIterativeNth1() {
        assertEquals(1, fibonacciIterative(1))
    }

    @Test
    fun fibonacciIterativeNth2() {
        assertEquals(1, fibonacciIterative(2))
    }

    @Test
    fun fibonacciIterativeNth5() {
        assertEquals(5, fibonacciIterative(5))
    }

    @Test
    fun fibonacciIterativeNth10() {
        assertEquals(55, fibonacciIterative(10))
    }

    @Test
    fun fibonacciIterativeNth20() {
        assertEquals(6765, fibonacciIterative(20))
    }

    @Test
    fun fibonacciRecursiveNth0() {
        assertEquals(0, fibonacciRecursive(0))
    }

    @Test
    fun fibonacciRecursiveNth1() {
        assertEquals(1, fibonacciRecursive(1))
    }

    @Test
    fun fibonacciRecursiveNth2() {
        assertEquals(1, fibonacciRecursive(2))
    }

    @Test
    fun fibonacciRecursiveNth5() {
        assertEquals(5, fibonacciRecursive(5))
    }

    @Test
    fun fibonacciRecursiveNth10() {
        assertEquals(55, fibonacciRecursive(10))
    }

    @Test
    fun fibonacciRecursiveNth200() {
        assertEquals(6765, fibonacciRecursive(20))
    }

    @Test
    fun fibonacciClosedFormNth0() {
        assertEquals(0, fibonacciClosedForm(0))
    }

    @Test
    fun fibonacciClosedFormNth1() {
        assertEquals(1, fibonacciClosedForm(1))
    }

    @Test
    fun fibonacciClosedFormNth2() {
        assertEquals(1, fibonacciClosedForm(2))
    }

    @Test
    fun fibonacciClosedFormNth5() {
        assertEquals(5, fibonacciClosedForm(5))
    }

    @Test
    fun fibonacciClosedFormNth10() {
        assertEquals(55, fibonacciClosedForm(10))
    }

    @Test
    fun fibonacciClosedFormNth20() {
        assertEquals(6765, fibonacciClosedForm(20))
    }

    @Test
    fun fibonacciDivideAndConquerNth0() {
        assertEquals(0, fibonacciDivideAndConquer(0))
    }

    @Test
    fun fibonacciDivideAndConquerNth1() {
        assertEquals(1, fibonacciDivideAndConquer(1))
    }

    @Test
    fun fibonacciDivideAndConquerNth2() {
        assertEquals(1, fibonacciDivideAndConquer(2))
    }

    @Test
    fun fibonacciDivideAndConquerNth5() {
        assertEquals(5, fibonacciDivideAndConquer(5))
    }

    @Test
    fun fibonacciDivideAndConquerNth10() {
        assertEquals(55, fibonacciDivideAndConquer(10))
    }

    @Test
    fun fibonacciDivideAndConquerNth20() {
        assertEquals(6765, fibonacciDivideAndConquer(20))
    }
}