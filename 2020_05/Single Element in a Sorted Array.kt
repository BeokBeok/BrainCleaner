class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        val counts = HashMap<Int, Int>()

        for (element in nums) {
            counts.computeIfAbsent(element) { 0 }
            if (counts.containsKey(element)) counts[element] = counts[element]!! + 1
        }
        return counts.minBy { it.value }?.key ?: 0
    }
}
