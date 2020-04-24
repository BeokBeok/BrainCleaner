class Solution {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var result = m
        for (i in m until n) {
            result = result.and(i + 1)
            if (result == 0) break
        }
        return result
    }
}
