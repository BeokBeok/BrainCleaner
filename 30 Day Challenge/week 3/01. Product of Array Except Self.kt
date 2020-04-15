class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.isEmpty()) return nums

        val zeroCnt = nums.count { it == 0 }
        if (zeroCnt > 1) return IntArray(nums.size)

        val multiple = nums.filter { it != 0 }.reduce { acc, i -> acc.times(i) }

        for (i in nums.indices) {
            if (nums[i] == 0) {
                nums[i] = multiple
                continue
            }
            if (nums.contains(0)){
                nums[i] = 0
            } else {
                nums[i] = multiple.div(nums[i])
            }
        }
        return nums
    }
}
