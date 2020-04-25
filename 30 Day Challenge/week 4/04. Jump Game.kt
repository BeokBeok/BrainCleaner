class Solution {

    fun canJump(nums: IntArray): Boolean {
        var last = nums.lastIndex
        for (i in last-1 downTo 0) {
            if (i + nums[i] >= last) last = i
        }
        return last <= 0
    }

}
