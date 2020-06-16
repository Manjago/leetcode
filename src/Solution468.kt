import java.util.regex.Pattern
import kotlin.test.assertEquals

fun main() {
    val sol = Solution468()
    assertEquals("IPv4", sol.validIPAddress("172.16.254.1"))
    assertEquals("IPv6", sol.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
    assertEquals("Neither", sol.validIPAddress("256.256.256.256"))
}

// https://leetcode.com/problems/validate-ip-address/
class Solution468 {
    fun validIPAddress(IP: String): String {
        if (pattenIPv4.matcher(IP).matches()) return "IPv4"
        return if (pattenIPv6.matcher(IP).matches()) "IPv6" else "Neither"
    }

    companion object {
        private const val chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"
        private val pattenIPv4: Pattern = Pattern.compile("^($chunkIPv4\\.){3}$chunkIPv4$")
        private const val chunkIPv6 = "([0-9a-fA-F]{1,4})"
        private val pattenIPv6: Pattern = Pattern.compile("^($chunkIPv6:){7}$chunkIPv6$")
    }
}