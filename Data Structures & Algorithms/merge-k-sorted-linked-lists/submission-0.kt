/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty()||lists[0]==null) return null
        val pq : PriorityQueue<ListNode> = PriorityQueue<ListNode>(lists.size, compareBy{it.`val`})

        for(list in lists) {
            list?.let {
                pq.add(list)
            }
        }
        var result : ListNode? = null
        if(!pq.isEmpty()) {
            val min = pq.poll()
            result = ListNode(min!!.`val`)
            min.next?.let {
                pq.add(min.next)
            }
        }
    
        var node = result
        while(!pq.isEmpty()) {
            val min = pq.poll()
            node?.next = ListNode(min!!.`val`)
            node = node?.next
            min?.next?.let {
                pq.add(min.next)
            }
        }
        return result
    }
}
