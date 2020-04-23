class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var (sum, count) = 0 to 0
        val sumToCnt = HashMap<Int, Int>()
        sumToCnt[0] = 1

        for (i in nums.indices) {
            sum += nums[i]
            if (sumToCnt.containsKey(sum - k)) {
                count += sumToCnt[sum - k]!!
            }
            sumToCnt[sum] = sumToCnt.getOrDefault(sum, 0) + 1
        }
        return count
    }
}
