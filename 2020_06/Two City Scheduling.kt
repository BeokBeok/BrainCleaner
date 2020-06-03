class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val halfRowLength = costs.size / 2
        val dp = Array(halfRowLength + 1) { IntArray(halfRowLength + 1) }

        for (i in 1..halfRowLength) {
            dp[i][0] = dp[i-1][0] + costs[i-1][0]
        }
        for (i in 1..halfRowLength) {
            dp[0][i] = dp[0][i-1] + costs[i-1][1]
        }
        for (i in 1..halfRowLength) {
            for (j in 1..halfRowLength) {
                dp[i][j] = (dp[i - 1][j] + costs[i + j - 1][0]).coerceAtMost(dp[i][j - 1] + costs[i + j - 1][1])
            }
        }
        return dp[halfRowLength][halfRowLength]
    }
}
