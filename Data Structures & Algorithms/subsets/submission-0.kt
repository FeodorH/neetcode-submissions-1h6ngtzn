class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        var mask = 0
        val result = mutableListOf<MutableList<Int>>()
        while(mask < Math.pow(2.0,nums.size.toDouble()).toInt()) {
            var maskCopy = mask
            val temp = mutableListOf<Int>()
            var i = 0
            while (i < nums.size && maskCopy != 0) {
                val bit = maskCopy and 1
                if(bit == 1){
                    temp.add(nums[i])
                }
                i++
                maskCopy = maskCopy shr 1
            }
            result.add(temp)
            mask++
        }
        return result
    }
}
