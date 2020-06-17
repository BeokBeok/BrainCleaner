data class Flights(
        val price: Int,
        val src: Int,
        val depth: Int
)

class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val prices = mutableMapOf<Int, Map<Int, Int>>() // key = src, value = dst to price
        for (element in flights) {
            prices.computeIfAbsent(element[0]) { HashMap() }
            (prices[element[0]] as MutableMap)[element[1]] = element[2]
        }
        val priorityQueue = PriorityQueue(
                Comparator { o1: Flights, o2: Flights ->
                    o1.price - o2.price
                }
        ).apply { add(Flights(price = 0, src = src, depth = K + 1)) } // price, src, depth

        while (priorityQueue.isNotEmpty()) {
            val element = priorityQueue.poll()
            if (element.src == dst) return element.price
            if (element.depth > 0) {
                for (destination in prices[element.src]?.keys ?: emptySet()) {
                    priorityQueue.add(
                            Flights(
                                    price = element.price + (prices[element.src]?.get(destination) ?: 0),
                                    src = destination,
                                    depth = element.depth - 1
                            )
                    )
                }
            }
        }
        return -1
    }
}
