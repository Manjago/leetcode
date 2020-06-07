import kotlin.test.assertEquals

fun main() {
    val sol = Solution518()
    assertEquals(4, sol.change(5, intArrayOf(1,2,5)))
    assertEquals(0, sol.change(3, intArrayOf(2)))
    assertEquals(1, sol.change(10, intArrayOf(10)))
}

// https://leetcode.com/problems/coin-change-2/
class Solution518 {

    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            for (i in 0..amount - coin) {
                dp[i + coin] += dp[i]
            }
        }
        return dp[amount]
    }
}