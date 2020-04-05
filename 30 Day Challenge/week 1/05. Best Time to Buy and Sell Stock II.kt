class Solution {
    fun maxProfit(prices: IntArray): Int {
        var (index, result) = 0 to 0
        var min: Int
        var max: Int

        while (index < prices.size - 1) {
            while (index < prices.size - 1 && prices[index] >= prices[index + 1]) {
                index++
            }
            min = prices[index]
            while (index < prices.size - 1 && prices[index] <= prices[index + 1]) {
                index++
            }
            max = prices[index]
            result += max - min
        }
        return result
    }
}
