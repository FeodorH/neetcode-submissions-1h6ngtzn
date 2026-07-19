class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val total = nums1.size + nums2.size
    if (total == 0) return 0.0
    if (total == 1) {
        return if (nums1.isNotEmpty()) nums1[0].toDouble() else nums2[0].toDouble()
    }

    var i1 = 0
    var i2 = 0
    var last = 0
    var now = 0

    // Идём до середины + 1 элемент, чтобы получить два центральных для чётной длины
    while (i1 + i2 <= total / 2) {
        last = now
        when {
            i1 < nums1.size && (i2 >= nums2.size || nums1[i1] <= nums2[i2]) -> {
                now = nums1[i1]
                i1++
            }
            i2 < nums2.size -> {
                now = nums2[i2]
                i2++
            }
        }
    }
    return if (total % 2 == 0) (last + now) / 2.0 else now.toDouble()
}
}
