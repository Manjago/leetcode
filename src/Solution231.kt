import java.util.concurrent.ConcurrentHashMap
import kotlin.math.pow
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val sol = Solution231()
    assertTrue(sol.isPowerOfTwo(1))
    assertTrue(sol.isPowerOfTwo(2))
    assertTrue(sol.isPowerOfTwo(8))
    assertFalse(sol.isPowerOfTwo(9))
    assertTrue(sol.isPowerOfTwo(16))
    assertTrue(sol.isPowerOfTwo(32))
    assertTrue(sol.isPowerOfTwo(64))
    assertTrue(sol.isPowerOfTwo(128))
    assertTrue(sol.isPowerOfTwo(256))
    assertTrue(sol.isPowerOfTwo(512))
    assertTrue(sol.isPowerOfTwo(1024))
    assertFalse(sol.isPowerOfTwo(218))
    assertFalse(sol.isPowerOfTwo(1023))
    assertFalse(sol.isPowerOfTwo(1025))
}

// https://leetcode.com/problems/power-of-two/
class Solution231 {

    private val double2 = 2.toDouble()

    private val cache = ConcurrentHashMap<Int, Int>()

    private fun cachedPow(a: Int) : Int {
        val pretender = cache[a]
        return if (pretender != null) {
            pretender
        } else {
            val result = double2.pow(a).toInt()
            cache[a] = result
            result
        }
    }

    fun isPowerOfTwo(n: Int): Boolean {

        if (n <= 0) {
            return false
        }
        if (n == 1) {
            return true
        }

        val limit = kotlin.math.log2(n.toDouble()).toInt()

        for (probe in 1..limit) {

            if (cachedPow(probe) == n) {
                return true
            }
        }

        return false
    }
}