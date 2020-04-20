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
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        val root = TreeNode(preorder[0])
        for (i in 1..preorder.lastIndex) {
            setupTreeNode(root, preorder[i])
        }
        return root
    }
    
    private tailrec fun setupTreeNode(target: TreeNode?, value: Int): TreeNode? {
        if (target == null) return target

        return when {
            target.`val` > value -> {
                if (target.left == null) target.left = TreeNode(value)
                setupTreeNode(target.left, value)
            }
            target.`val` < value -> {
                if (target.right == null) target.right = TreeNode(value)
                setupTreeNode(target.right, value)
            }
            else -> {
                target
            }
        }
    }
}
