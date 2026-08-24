/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var t = head
        var l = 0
        while (t != null) {
            l++
            t = t?.next
        }

        t = head
        var prev : ListNode? = null
        for(i in 0 until (l-n)){
            prev = t
            t = t?.next
        }

        if(prev != null){
            prev.next = t?.next
        }else{
            return t?.next
        }
        t?.next = null

        return head
    }
}