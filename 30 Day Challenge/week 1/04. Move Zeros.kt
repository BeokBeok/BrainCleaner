class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty()) return
        var insertPos = 0
        for (element in nums) {
            if (element != 0) nums[insertPos++] = element
        }

        for (i in insertPos until nums.size) {
            nums[i] = 0
        }
    }
}
