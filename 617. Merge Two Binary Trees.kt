/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1 == null && t2 == null) return null
        val t = TreeNode((t1?.`val` ?: 0) + ((t2?.`val` ?: 0)))
        t.left = mergeTrees(t1?.left, t2?.left)
        t.right = mergeTrees(t1?.right, t2?.right)
        return t
    }
}
