import kotlin.test.assertEquals

/*
before mark
[1, 1, 1]
[0, 1, 2]
after mark
[0, 1, 1]
[0, 1, 2]
after dozero
[0, 1, 1]
[0, 0, 0]
after dozero2
[0, 0, 0]
[0, 0, 0]
 */

fun main() {
    test(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        ),
        """
[1, 0, 1]
[0, 0, 0]
[1, 0, 1]
"""
    )

    test(
        arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        ),
        """
[0, 0, 0, 0]
[0, 4, 5, 0]
[0, 3, 1, 0]
"""
    )

}

fun test(matrix: Array<IntArray>, result: String) {
    Solution73().setZeroes(matrix)
    assertEquals(result.trimIndent(), matrix.dump())
}


fun Array<IntArray>.dump(): String {
    val sb = StringBuilder()
    for (i in this.indices) {
        if (i != 0) {
            sb.append("\n")
        }
        sb.append(this[i].contentToString())
    }
    return sb.toString()
}

// https://leetcode.com/problems/set-matrix-zeroes/
class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {

        //mark
        var needZeroColumn0 = false
        var needZeroRow0 = false
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        needZeroRow0 = true
                    } else {
                        matrix[i][0] = 0
                    }
                    if (j == 0) {
                        needZeroColumn0 = true
                    } else {
                        matrix[0][j] = 0
                    }
                }
            }
        }

        //zero rows 1..size
        for (i in 1 until matrix.size) {
            if (matrix[i][0] == 0) {
                for (j in 1 until matrix[i].size) {
                    matrix[i][j] = 0
                }
            }
        }

        //zero columns 1..size
        for (j in 1 until matrix[0].size) {
            if (matrix[0][j] == 0) {
                for (i in 1 until matrix.size) {
                    matrix[i][j] = 0
                }
            }
        }

        // zero row 0
        if (needZeroRow0) {
            for (j in matrix[0].indices) {
                matrix[0][j] = 0
            }
        }

        //zero column 0
        if (needZeroColumn0) {
            for (element in matrix) {
                element[0] = 0
            }
        }

    }

}