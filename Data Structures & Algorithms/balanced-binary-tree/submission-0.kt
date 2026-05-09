/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean = when (haight(root)){
        -1 -> false
        else -> true
    }
    
    fun haight(root: TreeNode?): Int {
        if (root == null) return 0
        val lH = haight(root.left)
        val rH = haight(root.right)
        if (lH == -1 || rH == -1) {return -1}
        if(Math.abs(lH-rH)>1)return -1
        else{
            return Math.max(lH, rH)+1
        }
    }
}
