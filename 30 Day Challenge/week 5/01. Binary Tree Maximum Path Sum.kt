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
    private var max = Int.MIN_VALUE
    
    fun maxPathSum(root: TreeNode?): Int {
        calMaxPath(root)
        return max
    }
    
    private fun calMaxPath(root: TreeNode?): Int {
        if (root == null) return 0

        val left = calMaxPath(root.left).coerceAtLeast(0)
        val right = calMaxPath(root.right).coerceAtLeast(0)

        max = max.coerceAtLeast(root.`val` + left + right)
        return root.`val` + left.coerceAtLeast(right)
    }
}
