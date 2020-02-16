// 문제 링크 - https://leetcode.com/problems/construct-string-from-binary-tree/ 

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
    fun tree2str(t: TreeNode?): String {
        if (t == null) return ""

        val rightOnlyNullCasePhrases = "${t.`val`}(${tree2str(t.left)})"
        val leftRightNullCasePhrases = "${t.`val`}"
        val commonCasePhrases = "${t.`val`}(${tree2str(t.left)})(${tree2str(t.right)})"

        return if (t.left != null && t.right == null) rightOnlyNullCasePhrases
        else if (t.left == null && t.right == null) leftRightNullCasePhrases
        else commonCasePhrases        
    }
}
