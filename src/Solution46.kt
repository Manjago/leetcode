fun main() {
    val s = Solution46()
    println(s.permute(intArrayOf()))
    println(s.permute(intArrayOf(1)))
    println(s.permute(intArrayOf(1, 2)))
    println(s.permute(intArrayOf(1, 2, 3)))
    println(s.permute(intArrayOf(1, 2, 3, 4)))
}

// https://leetcode.com/problems/permutations/
class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        backtrack(nums.asSequence() .map { it }.toSet(), answer, listOf())
        return answer
    }

    private fun backtrack(data : Set<Int>, answer: MutableList<List<Int>>, pretender: List<Int>) {
        if (data.isEmpty()) {
            answer.add(pretender)
        } else {
            data.asSequence().forEach {
                backtrack(data.minus(it), answer, pretender.plus(it))
            }
        }
    }

}