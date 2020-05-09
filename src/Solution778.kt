import kotlin.test.assertEquals

fun main() {
    val solution = Solution778()

    assertEquals("aet", solution.sortString("eat"))
    assertEquals("aet", solution.sortString("tea"))
    val result = solution.groupAnagrams(
        arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    )
    assertEquals("[[eat, tea, ate], [tan, nat], [bat]]", result.toString())
}

class Solution778 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val preResult: MutableMap<String, MutableList<String>> = mutableMapOf()
        for(string in strs) {
            val key = sortString(string)
            if (preResult.containsKey(key)) {
                val list = preResult[key]!!
                list.add(string)
            } else {
                preResult.put(key, mutableListOf(string))
            }
        }

        return preResult.values.asSequence().toList()
    }

    fun sortString(s: String): String {
        val tempCharArray = s.toCharArray()
        tempCharArray.sort()
        return tempCharArray.joinToString("")
    }
}