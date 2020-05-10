import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.test.assertEquals

fun main() {
    val s = Solution4()
    assertEquals(7.0, s.findMedianSortedArrays(intArrayOf(1, 3, 5, 7, 9, 11),
        intArrayOf(2, 4, 6, 8, 10, 12, 100)))
    assertEquals(7.0, s.findMedianSortedArrays(intArrayOf(1, 2, 3, 5, 7, 9, 11),
        intArrayOf(4, 6, 8, 10, 12, 100)))
    assertEquals(2.5, s.median4int(1, 2, 3, 4))
    assertEquals(2.5, s.findMedianSortedArrays(intArrayOf(), intArrayOf(1, 2, 3, 4)))
    assertEquals(2.0, s.median2int(1, 3))
    assertEquals(2.0, s.median2int(1, 3.0))
    assertEquals(1.5, s.median2int(1, 2))
    assertEquals(1.5, s.median2int(1, 2.0))
    assertEquals(10.0, s.median3int(10, 8, 900))
    assertEquals(2.0, s.median3int(1, 2, 3))
    assertEquals(10.0, s.median3int(1, 10, 100))
    assertEquals(2.5, s.median4int(1, 2, 3, 4))
    assertEquals(16.0, s.median4int(1, 2, 30, 400))
    assertEquals(
        intArrayOf(3, 4, 5, 6).contentToString(),
        (s.lamecopy(intArrayOf(1, 2, 3, 4, 5, 6, 7), 2, 4)).contentToString()
    )
    assertEquals(10.0, s.findMedianSortedArrays(intArrayOf(900), intArrayOf(5, 8, 10, 20)))
    assertEquals(10.0, s.findMedianSortedArrays(intArrayOf(5, 8, 10, 20), intArrayOf(900)))
    assertEquals(2.0, s.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    assertEquals(2.5, s.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))

    assertEquals(7.0, s.findMedianSortedArrays(intArrayOf(),
        intArrayOf(1, 2, 3, 4, 5, 6,
            7,
            8, 9, 10, 11, 12, 100)))
}

// https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution4 {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        if (nums1.size > nums2.size) {
            return median(nums2, nums1)
        } else {
            return median(nums1, nums2)
        }

    }

    fun median2int(num1: Int, num2: Int): Double =
        (num1 + num2) / 2.0

    fun median2int(num1: Int, num2: Double): Double =
        (num1 + num2) / 2

    fun median3int(num1: Int, num2: Int, num3: Int): Double =
        (num1 + num2 + num3 - max(num1, max(num2, num3)) -
                min(num1, min(num2, num3))).toDouble()

    fun median4int(num1: Int, num2: Int, num3: Int, num4: Int): Double {
        val minVar = max(num1, max(num2, max(num3, num4)))
        val maxVar = min(num1, min(num2, min(num3, num4)))
        return (num1 + num2 + num3 + num4 - minVar - maxVar) / 2.0
    }

    fun median1array(nums: IntArray): Double {
        val n = nums.size
        return when {
            n == 0 -> -1.0
            n % 2 == 0 -> ((nums[n / 2] + nums[n / 2 - 1]).toDouble() / 2)
            else -> nums[n / 2].toDouble()
        }
    }

    fun lamecopy(src: IntArray, from: Int, len: Int): IntArray {
        val res = IntArray(len)
        var counter = 0
        for (i in from until from + len) {
            res[counter++] = src[i]
        }
        return res
    }

    fun median(nums1: IntArray, nums2: IntArray): Double {
        val n1 = nums1.size
        val n2 = nums2.size

        when (n1) {
            0 -> return median1array(nums2)
            1 -> return when {
                n2 == 1 -> median2int(nums1[0], nums2[0])
                n2 % 2 != 0 -> median2int(
                    nums2[n2 / 2],
                    median3int(nums1[0], nums2[n2 / 2 - 1], nums2[n2 / 2 + 1])
                )
                else -> median3int(nums2[n2 / 2], nums2[n2 / 2 - 1], nums1[0])
            }
            2 -> return when {
                n2 == 2 -> median4int(nums1[0], nums1[1], nums2[0], nums2[1])
                n2 % 2 != 0 -> median3int(
                    nums2[n2 / 2],
                    max(nums1[0], nums2[n2 / 2 - 1]),
                    min(nums1[1], nums2[n2 / 2 + 1])
                )
                else -> median4int(
                    nums2[n2 / 2], nums2[n2 / 2 - 1],
                    max(nums1[0], nums2[n2 / 2 - 2]),
                    min(nums1[1], nums2[n2 / 2 + 1])
                )
            }
            else -> {
                val index1 = (n1 - 1) / 2
                val index2 = (n2 - 1) / 2

                return if (nums1[index1] <= nums2[index2]) {
                    median(
                        lamecopy(nums1, index1, n1 / 2 + 1),
                        lamecopy(nums2, 0, n2 - index1)
                    )
                } else {
                    median(
                        lamecopy(nums1, 0, n1 / 2 + 1),
                        lamecopy(nums2, index1, n2 - index1)
                    )

                }

            }
        }

    }
}