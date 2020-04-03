class Solution {
    fun singleNumber(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return nums.reduce { acc, i -> acc xor i }
    }
}
