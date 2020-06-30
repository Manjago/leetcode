import java.util.*

// https://leetcode.com/problems/word-search-ii/
class Solution212 {
    var result = mutableSetOf<String>()
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie()
        for (word in words) {
            trie.insert(word)
        }
        val m = board.size
        val n: Int = board[0].size
        val visited = Array(m) { BooleanArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                dfs(board, visited, "", i, j, trie)
            }
        }
        return ArrayList(result)
    }

    private fun dfs(board: Array<CharArray>, visited: Array<BooleanArray>, str: String, i: Int, j: Int, trie: Trie) {
        var str = str
        val m = board.size
        val n: Int = board[0].size
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return
        }
        if (visited[i][j]) return
        str += board[i][j]
        if (!trie.startsWith(str)) return
        if (trie.search(str)) {
            result.add(str)
        }
        visited[i][j] = true
        dfs(board, visited, str, i - 1, j, trie)
        dfs(board, visited, str, i + 1, j, trie)
        dfs(board, visited, str, i, j - 1, trie)
        dfs(board, visited, str, i, j + 1, trie)
        visited[i][j] = false
    }
}

class TrieNode {
    var children = arrayOfNulls<TrieNode>(26)
    var item = ""
}

class Trie {
    private var root = TrieNode()
    fun insert(word: String) {
        var node: TrieNode? = root
        for (c in word.toCharArray()) {
            if (node!!.children[c - 'a'] == null) {
                node.children[c - 'a'] = TrieNode()
            }
            node = node.children[c - 'a']
        }
        node!!.item = word
    }

    fun search(word: String): Boolean {
        var node: TrieNode? = root
        for (c in word.toCharArray()) {
            if (node!!.children[c - 'a'] == null) return false
            node = node.children[c - 'a']
        }
        return node!!.item == word
    }

    fun startsWith(prefix: String): Boolean {
        var node: TrieNode? = root
        for (c in prefix.toCharArray()) {
            if (node!!.children[c - 'a'] == null) return false
            node = node.children[c - 'a']
        }
        return true
    }
}