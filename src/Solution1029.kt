import kotlin.test.assertEquals

fun main() {
    val sol = Solution1029()
    val testData = arrayOf(
        intArrayOf(10, 20),
        intArrayOf(30, 200),
        intArrayOf(400, 50),
        intArrayOf(30, 20)
    )

    assertEquals(110, sol.twoCitySchedCost(testData))
}

// https://leetcode.com/problems/two-city-scheduling/
class Solution1029 {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {

        val limit = costs.size / 2
        var counterA = 0
        var counterB = 0
        var answer = 0
        costs.asSequence().sortedBy {
            -kotlin.math.abs(it[0] - it[1])
        }.forEach {
            val cost = it[0] - it[1]

            if (( (counterA < limit) && (cost <= 0) ) || (counterB == limit)) {
                answer += it[0]
                ++counterA
            } else {
                ++counterB
                answer += it[1]
            }
        }

        return answer
    }
}