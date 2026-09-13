class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<Triple<Double, Int, Int>>(compareBy { -it.first })
        for (el in points) {
            val x = el[0]
            val y = el[1]
            val dist: Double = sqrt(x * x * 1.0 + y * y)
            if (heap.size < k) {
                heap.add(Triple(dist, x, y))
            } else if (dist < heap.peek().first) {
                heap.poll()
                heap.add(Triple(dist, x, y))
            }
        }
        val result = mutableListOf<IntArray>()
        for (el in heap) {
            result.add(intArrayOf(el.second, el.third))
        }
        return result.toTypedArray()
    }
}
