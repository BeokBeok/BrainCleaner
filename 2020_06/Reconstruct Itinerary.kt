class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        fun visit(target: HashMap<String, PriorityQueue<String>>, point: String, result: MutableList<String>) {
            while (target.containsKey(point) && !target[point].isNullOrEmpty()) {
                visit(target, target[point]!!.poll(), result)
            }
            result.add(0, point)
        }
        val (target, result) = HashMap<String, PriorityQueue<String>>() to mutableListOf<String>()
        for (element in tickets) {
            target.computeIfAbsent(element[0]) { PriorityQueue() }.add(element[1])
        }
        visit(target, "JFK", result)
        return result
    }
}
