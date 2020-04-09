/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        if (head == null) return null

        var totalCnt = 1
        var target: ListNode? = head
        while (target?.next != null) {
            target = target.next
            totalCnt++
        }

        val startPos = totalCnt / 2
        target = head
        for (i in 1..startPos) {
            target = target?.next
        }
        return target
    }
}
