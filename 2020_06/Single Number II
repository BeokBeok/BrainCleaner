class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.groupBy { it }
            .filter { it.value.size == 1 }
            .keys
            .firstOrNull() ?: 0
    }
}
