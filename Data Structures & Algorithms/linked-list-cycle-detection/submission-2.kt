/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution{
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        do {
            if(slow?.next != null && fast?.next != null && fast?.next?.next != null){
                slow = slow?.next
                fast = fast?.next?.next
            }else{
                return false
            }
        } while(slow != fast)
        return true
    }
}
