class Solution {
    fun longestConsecutive(nums: IntArray): Int {
    val set = TreeSet<Int>()
    var result = mutableListOf<Int>()
    if(nums.isEmpty()) return 0

    for (el in nums) {
        set.add(el)
    }

    var temp = mutableListOf<Int>()
    var it = set.iterator()
    var prev = it.next()
    temp.add(prev)
    while (it.hasNext()) {
        val t = it.next()
        if (t - prev == 1) {
            temp.add(t)
        } else {
            if (result.size < temp.size) {
                result = temp
            }
            temp = mutableListOf<Int>()
            temp.add(t)
        }
        prev = t
    }
    if (result.size < temp.size) {
        result = temp
    }
    return result.size
    }
}
