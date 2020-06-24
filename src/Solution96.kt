// https://leetcode.com/problems/unique-binary-search-trees/
class Solution96 {
    fun numTrees(n: Int): Int {
        val count = IntArray(n + 1)
        count[0] = 1
        count[1] = 1
        for (i in 2..n) {
            for (j in 0 until i) {
                count[i] = count[i] + count[j] * count[i - j - 1]
            }
        }
        return count[n]
    }
}