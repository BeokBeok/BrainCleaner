class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counter = Array(26) { 0 }
        var (max, maxCount) = 0 to 0

        for (task in tasks) {
            counter[task - 'A']++
            if (max == counter[task - 'A']) {
                maxCount++
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A']
                maxCount = 1
            }
        }

        val (partCount, partLength) = max - 1 to n - (maxCount - 1)
        val emptySlot = partCount * partLength
        val availableTasks = tasks.size - max * maxCount
        val idle = 0.coerceAtLeast(emptySlot - availableTasks)

        return tasks.size + idle
    }
}
