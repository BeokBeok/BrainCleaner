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
    var maxDepth = 0
    
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        getMaxDepth(root)
        return maxDepth
    }

    private fun getMaxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        
        val left = getMaxDepth(root.left)
        val right = getMaxDepth(root.right)
        
        maxDepth = maxDepth.coerceAtLeast(left + right)
        
        val selfDepth = 1
        return left.coerceAtLeast(right) + selfDepth
    }
}
