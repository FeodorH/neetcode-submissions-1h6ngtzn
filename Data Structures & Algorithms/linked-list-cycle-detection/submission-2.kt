/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        if(head == null) return false
        if(head?.next === head) return true
        var el1 : ListNode? = head
        var el2 : ListNode? = head?.next
        while(el2 != null && el2.next != null && el1!=null){
            if(el1 === el2){
                return true
            }
            el1 = el1?.next
            el2 = el2?.next?.next
        }
        return false
    }

//    class ListNode(var `val`: Int) {
//        var next: ListNode? = null
//    }
}