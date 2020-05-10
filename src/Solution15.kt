import kotlin.test.assertEquals

fun main() {
    val sol = Solution15()
    assertEquals(Solution15.Triplet(1, 2, 3), sol.sortedTriplet(1, 2, 3))
    assertEquals(Solution15.Triplet(1, 2, 3), sol.sortedTriplet(1, 3, 2))
    assertEquals(Solution15.Triplet(1, 2, 3), sol.sortedTriplet(2, 3, 1))
    assertEquals(Solution15.Triplet(1, 2, 3), sol.sortedTriplet(2, 1, 3))
    assertEquals(Solution15.Triplet(1, 2, 3), sol.sortedTriplet(3, 1, 2))
    assertEquals(Solution15.Triplet(1, 2, 3), sol.sortedTriplet(3, 2, 1))

    val result = sol.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    assertEquals("[[-1, -1, 2], [-1, 0, 1]]", result.toString())
    val result2 = sol.threeSum(intArrayOf(0, 0))
    assertEquals("[]", result2.toString())

}

// https://leetcode.com/problems/3sum/
class Solution15 {

    fun threeSum(nums: IntArray): List<List<Int>> {

        val data: MutableMap<Int, Int> = mutableMapOf()

        for (num: Int in nums) {
            val savedValue = data[num]
            data[num] = if (savedValue != null) savedValue + 1 else 1
        }

        val triplets = mutableSetOf<Triplet>()
        for (p1 in data.keys) {
            for (p2 in data.keys) {
                if (!data.allowDup(p1, p2, 1)) {
                    continue
                }

                val p3 = -p1 - p2

                if (data.containsKey(p3)) {
                    val allow = when (p1) {
                        p2 -> data.allowDup(p1, p3, 2)
                        else -> data.allowDup(p1, p3, 1) && data.allowDup(p2, p3, 1)
                    }
                    if (allow) {
                        triplets.add(sortedTriplet(p1, p2, p3))
                    }
                }
            }
        }

        return triplets.asSequence().map { listOf(it.a, it.b, it.c) }.toList()
    }

    fun MutableMap<Int, Int>.allowDup(key1: Int, key2: Int, limit: Int) =
        (key1 != key2) || (this.hasDup(key2, limit))

    fun MutableMap<Int, Int>.hasDup(key: Int, limit: Int = 1) = this[key]!! > limit

    fun sortedTriplet(a: Int, b: Int, c: Int) = if (a <= b) {
        if (b <= c) {
            Triplet(a, b, c)
        } else {
            if (a <= c) {
                Triplet(a, c, b)
            } else {
                Triplet(c, a, b)
            }
        }
    } else {
        if (a <= c) {
            Triplet(b, a, c)
        } else {
            if (b <= c) {
                Triplet(b, c, a)
            } else {
                Triplet(c, b, a)
            }
        }
    }

    data class Triplet(val a: Int, val b: Int, val c: Int)

}