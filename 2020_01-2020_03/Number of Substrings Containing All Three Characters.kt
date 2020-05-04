data class CountGroup(
    var a: Int,
    var b: Int,
    var c: Int
)

class Solution {
    fun numberOfSubstrings(s: String): Int {
        if (s.isEmpty()) return 0

        val countGroup = CountGroup(a = 0, b = 0, c = 0)
        var (count, result) = 0 to 0

        for (i in s.indices) {
            when (s.toCharArray()[i] - 'a') {
                0 -> countGroup.a++
                1 -> countGroup.b++
                2 -> countGroup.c++
            }
            while (countGroup.a > 0 && countGroup.b > 0 && countGroup.c > 0) {
                when (s.toCharArray()[count++] - 'a') {
                    0 -> countGroup.a--
                    1 -> countGroup.b--
                    2 -> countGroup.c--
                }
            }
            result += count
        }
        return result
    }
}
