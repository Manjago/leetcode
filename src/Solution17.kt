import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val s = Solution17()
    val pos = IntArray(3) { 0 }
    assertEquals("adg", s.translate("234".toCharArray(), pos))
    pos[1] = 1
    assertEquals("aeg", s.translate("234".toCharArray(), pos))

    var pos2 = IntArray(3) { 0 }
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[1, 0, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[2, 0, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[0, 1, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[1, 1, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[2, 1, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[0, 2, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[1, 2, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[2, 2, 0]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[0, 0, 1]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[1, 0, 1]", pos2.contentToString())
    assertTrue(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[2, 0, 1]", pos2.contentToString())

    pos2 = intArrayOf(2, 2, 2)
    assertFalse(s.inc(0, "234".toCharArray(), pos2))
    assertEquals("[0, 0, 0]", pos2.contentToString())

    val result = s.letterCombinations("23")
    assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]",
        result.sorted().toTypedArray().contentToString())
}

// https://leetcode.com/problems/letter-combinations-of-a-phone
class Solution17 {

    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        if (digits.isBlank()) {
            return result
        }

        val d = digits.toCharArray()
        val pos = IntArray(digits.length){0}
        result.add(translate(d, pos))

        while(inc(0, d, pos)) {
            result.add(translate(d, pos))
        }
        return result
    }

    fun inc(i: Int, d: CharArray, pos: IntArray): Boolean {
        if (i > pos.lastIndex) {
            return false
        }
        val currentChar = d[i]
        val currentDict = DICT.getValue(currentChar)
        val pretender = pos[i] + 1

        return if (pretender > currentDict.lastIndex) {
            pos[i] = 0
            inc(i + 1, d, pos)
        } else {
            pos[i] = pretender
            true
        }
    }

    fun translate(d: CharArray, pos: IntArray): String {
        return d.withIndex().asSequence().map {
             DICT[it.value]?.get(pos[it.index])
        }.filterNotNull().joinToString("")
    }

    companion object {
        private val DICT = mapOf(
            '2' to charArrayOf('a', 'b', 'c'),
            '3' to charArrayOf('d', 'e', 'f'),
            '4' to charArrayOf('g', 'h', 'i'),
            '5' to charArrayOf('j', 'k', 'l'),
            '6' to charArrayOf('m', 'n', 'o'),
            '7' to charArrayOf('p', 'q', 'r', 's'),
            '8' to charArrayOf('t', 'u', 'v'),
            '9' to charArrayOf('w', 'x', 'y', 'z')
        )
    }
}