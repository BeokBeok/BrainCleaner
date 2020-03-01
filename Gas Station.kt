class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        // 기저 case
        if (gas.isEmpty() || cost.isEmpty()) return -1

        // startingPoint 를 0 부터 순회
        for (startingPoint in gas.indices) {
            var currentGasAmount = gas[startingPoint]

            // 현재 가스량이 비용보다 적은 경우
            if (currentGasAmount < cost[startingPoint]) continue

            // 가스량이 1 인 경우
            if (startingPoint == 0 && gas.size == 1) return startingPoint

            // startingPoint 를 기준으로 각 gas station 순회
            for (i in startingPoint + 1 until gas.size + startingPoint) {
                val position = if (i >= gas.size) i - gas.size else i
                currentGasAmount = currentGasAmount - cost[if (position - 1 < 0) gas.size - 1 else position -1] + gas[position]
                if (currentGasAmount < cost[position]) break
                if (i == gas.size - 1 + startingPoint) return startingPoint
            }
        }
        return -1
    }
}
