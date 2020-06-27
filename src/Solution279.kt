import kotlin.math.min
import kotlin.math.sqrt

// https://leetcode.com/problems/perfect-squares/
class Solution279 {
    fun numSquares(n: Int): Int {
        val max = sqrt(n.toDouble()).toInt()
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        for (i in 1..n) {
            for (j in 1..max) {
                if (i == j * j) {
                    dp[i] = 1
                } else if (i > j * j) {
                    dp[i] = min(dp[i], dp[i - j * j] + 1)
                }
            }
        }
        return dp[n]
    }
}