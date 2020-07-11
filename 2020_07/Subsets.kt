class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        Arrays.sort(nums)
        backtrack(list, mutableListOf(), nums, 0)
        return list
    }

    private fun backtrack(
        list: MutableList<List<Int>>, 
        temp: MutableList<Int>, 
        nums: IntArray, 
        start: Int
    ) {
        list.add(temp.map { it })
        for (i in start..nums.lastIndex) {
            temp.add(nums[i])
            backtrack(list, temp, nums, i + 1)
            temp.removeAt(temp.lastIndex)
        }
    }
}
