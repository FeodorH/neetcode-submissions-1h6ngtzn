class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        fun perm(list: List<Int>) {
            val u = list.size
            if (u == nums.size) {
                res.add(list)
                return
            }

            for (i in 0 until nums.size) {
                if(!list.contains(nums[i])) {
                    perm(list + nums[i])
                }
            }
        }
        perm(emptyList())
        return res
    }
}
