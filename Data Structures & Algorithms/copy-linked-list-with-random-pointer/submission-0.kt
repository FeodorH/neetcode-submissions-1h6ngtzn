/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {

fun copyRandomList(head: Node?): Node? {
    if (head == null) return null
    
    val rHead = Node(head.`val`)
    
    // Создаем next связи
    var t: Node? = head
    var rT: Node? = rHead
    while (t?.next != null) {
        rT?.next = Node(t.next!!.`val`)  // Добавлен ?.
        t = t.next
        rT = rT?.next  // Используем ?. вместо !!
    }
    
    // Устанавливаем random связи (O(n²))
    t = head
    rT = rHead
    while (t != null) {
        if (t.random != null) {
            var t0: Node? = head
            var rT0: Node? = rHead
            // Ищем соответствующий узел в копии
            while (t0 != t.random) {
                t0 = t0?.next
                rT0 = rT0?.next
            }
            rT?.random = rT0  // Добавлен ?.
        }
        t = t.next
        rT = rT?.next  // Используем ?. вместо .next
    }
    
    return rHead
}

}

