fun main() {
    println(Solution62().uniquePaths(10, 10))
}

// https://leetcode.com/problems/unique-paths/
class Solution62 {
    fun uniquePaths(m: Int, n: Int): Int {

        val mem = Array(m) { IntArray(n){-1} }

        fun helper(m: Int, n: Int): Int = when {
            mem[m][n] != -1 -> mem[m][n]
            m == 0 || n == 0 -> {
                mem[m][n] = 1
                mem[m][n]
            }
            else -> {
                mem[m][n] = helper(m, n - 1) + helper(m - 1, n)
                mem[m][n]
            }
        }

        return helper(m - 1, n - 1)
    }

}