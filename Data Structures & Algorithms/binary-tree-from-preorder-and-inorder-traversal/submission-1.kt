/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if(preorder.isEmpty()) return null
        if(preorder.size == 1) return TreeNode(preorder[0])

        val node = TreeNode(preorder[0])

        val inLeft : IntArray = inorder.slice(0..<inorder.indexOf(preorder[0])).toIntArray()
        val inRight : IntArray = inorder.slice(inorder.indexOf(preorder[0])+1..inorder.size-1).toIntArray()

        var index = 1
        while (index < preorder.size) {
            if(!inLeft.contains(preorder[index])){
                break
            }
            index++
        }

        val preLeft = preorder.slice(1..index-1).toIntArray()
        val preRight = preorder.slice(index..<preorder.size).toIntArray()

        node.left = buildTree(preLeft, inLeft)
        node.right = buildTree(preRight, inRight)
        return node
    }
}
