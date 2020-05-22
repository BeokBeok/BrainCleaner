class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (element in nums) {
            if (map.containsKey(element)) {
                map[element] = (map[element] ?: 0) + 1
            } else {
                map[element] = 1
            }
        }
        return map.maxBy { it.value }?.key ?: 0
    }
}
