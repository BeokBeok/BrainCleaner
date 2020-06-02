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
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root
        val temp = root.left
        root.left = root.right
        root.right = temp
        if (root.left != null) invertTree(root.left)
        if (root.right != null) invertTree(root.right)
        return root
    }
}
