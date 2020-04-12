class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        if (stones.isEmpty()) return 0
        if (stones.size == 1) return stones[0]

        val stoneList = stones.toMutableList()

        while (stoneList.size > 1) {
            val firstMax = stoneList.max() ?: 0
            stoneList.remove(firstMax)
            val secondMax = stoneList.max() ?: 0
            stoneList.remove(secondMax)

            if (firstMax != secondMax) {
                stoneList.add(firstMax - secondMax)
            }
        }

        return if (stoneList.isEmpty()) 0 else stoneList[0]
    }
}
