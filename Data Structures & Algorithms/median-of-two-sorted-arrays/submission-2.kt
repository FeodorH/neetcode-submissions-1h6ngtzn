class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size + nums2.size <= 1) {
            if (!nums1.isEmpty()) return nums1[0].toDouble()
            else if (!nums2.isEmpty()) return nums2[0].toDouble()
            else return 0.0
        }
        var i1 = 0
        var i2 = 0
        var last = 0
        var now = 0
        while (i1 + i2 < ((nums1.size + nums2.size) / 2 + 1)) {
            last = now
            if (i1 < nums1.size && i2 < nums2.size) {
                if (nums1[i1] < nums2[i2]) {
                    now = nums1[i1]
                    i1++
                } else {
                    now = nums2[i2]
                    i2++
                }
            } else if (i1 < nums1.size) {
                now = nums1[i1]
                i1++
            } else if (i2 < nums2.size) {
                now = nums2[i2]
                i2++
            }
        }
        if ((nums1.size + nums2.size) % 2 == 0) {
            return (last.toDouble() + now) / 2
        } else {
            return now.toDouble()
        }
    }
}
