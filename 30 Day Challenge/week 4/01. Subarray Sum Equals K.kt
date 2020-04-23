class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.size == 1 && k == nums[0]) return 1

        var (sum, count) = 0 to 0
        for (i in nums.indices) {
            sum = nums[i]
            if (sum == k) {
                count++
            }
            for (j in i + 1..nums.lastIndex) {
                sum += nums[j]
                if (sum == k) {
                    count++
                }
            }
        }

        return count
    }
}
