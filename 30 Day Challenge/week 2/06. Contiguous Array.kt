class Solution {
    fun findMaxLength(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        
        var (sum, max) = 0 to 0
        val sumToIndex = hashMapOf<Int, Int>().apply { put(0, -1) }
        for (i in nums.indices) {
            sum += if (nums[i] == 0) -1 else 1
            if (sumToIndex.containsKey(sum)) {
                max = max.coerceAtLeast(i - (sumToIndex[sum] ?: -1))
            } else {
                sumToIndex[sum] = i
            }
        }
        return max
    }
}
