class Solution {
    fun firstUniqChar(s: String): Int {
        val counts = IntArray(26)

        for (element in s.toCharArray()) {
            counts[element - 'a']++
        }

        s.toCharArray().forEachIndexed { index, c ->
            if (counts[c - 'a'] == 1) {
                return index
            }
        }
        return -1
    }
}
