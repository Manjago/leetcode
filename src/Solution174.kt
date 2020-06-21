import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/dungeon-game/
class Solution174 {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val m = dungeon.size
        val n: Int = dungeon[0].size
        val h = Array(m) { IntArray(n) }
        h[m - 1][n - 1] = max(1 - dungeon[m - 1][n - 1], 1)
        for (i in m - 2 downTo 0) {
            h[i][n - 1] = max(h[i + 1][n - 1] - dungeon[i][n - 1], 1)
        }
        for (j in n - 2 downTo 0) {
            h[m - 1][j] = max(h[m - 1][j + 1] - dungeon[m - 1][j], 1)
        }
        for (i in m - 2 downTo 0) {
            for (j in n - 2 downTo 0) {
                val down = max(h[i + 1][j] - dungeon[i][j], 1)
                val right = max(h[i][j + 1] - dungeon[i][j], 1)
                h[i][j] = min(right, down)
            }
        }
        return h[0][0]
    }
}