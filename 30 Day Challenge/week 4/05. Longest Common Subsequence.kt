import kotlin.math.max

class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val (col, row) = text1.length + 1 to text2.length + 1
        val dp = Array(row) { IntArray(col) }

        for (i in 1 until row) {
            for (j in 1 until col) {
                if (text1[j - 1] == text2[i - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                }
            }
        }
        return dp[row-1][col-1]
    }
}
