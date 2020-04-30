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
    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean =
        calValidSequence(root, arr, 0)
    
    private fun calValidSequence(root: TreeNode?, arr: IntArray, index: Int): Boolean {
        if (root == null || index > arr.lastIndex) return false
        if (root.left == null && root.right == null) {
            return root.`val` == arr[index] && index == arr.lastIndex
        }
        if (root.`val` == arr[index]) {
            return calValidSequence(root.left, arr, index + 1) || calValidSequence(root.right, arr, index + 1)
        }
        return false
    }
}
