import java.util.PriorityQueue
import kotlin.Comparator

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val priorityQueue = PriorityQueue(
            Comparator { a: Int, b: Int ->
                b - a
            }
        )
        for (element in stones) {
            priorityQueue.add(element)
        }
        while (priorityQueue.size > 1) {
            priorityQueue.offer(priorityQueue.poll() - priorityQueue.poll())
        }
        return priorityQueue.first()
    }
}
