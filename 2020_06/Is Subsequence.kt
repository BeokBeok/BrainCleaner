class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val queue: Queue<Char> = LinkedList()
        for (element in t) {
            queue.offer(element)
        }

        var count = 0
        for (element in s) {
            while (queue.size > 0) {
                val target = queue.poll()
                if (element == target) {
                    count ++
                    break
                }
            }
        }
        return count == s.length
    }
}
