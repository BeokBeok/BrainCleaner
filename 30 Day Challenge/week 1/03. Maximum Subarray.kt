class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        val sumList = mutableListOf<Int>()
        sumList.add(nums[0])

        for (i in 1 until nums.size) {
            sumList.add(nums[i] + if(sumList[i - 1] > 0) sumList[i - 1] else 0)
            max = max.coerceAtLeast(sumList[i])
        }
        return max
    }
}
