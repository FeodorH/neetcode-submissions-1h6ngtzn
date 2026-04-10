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
    
    val map = mutableMapOf<Node, Node>()
    var current = head
    
    // Шаг 1: Создаем все узлы
    while (current != null) {
        map[current] = Node(current.`val`)
        current = current.next
    }
    
    // Шаг 2: Устанавливаем ссылки
    current = head
    while (current != null) {
        map[current]?.next = current.next?.let { map[it] }
        map[current]?.random = current.random?.let { map[it] }
        current = current.next
    }
    
    return map[head]
}

}

