class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return -1
        if(nums.size == 1) return if(nums[0] == target) 0 else -1
        if (nums.size == 2) return if(nums[0] == target) 0 else if(nums[1] == target) 1 else -1
        var a = 0
        var b = nums.size - 1
        var t: Int
        while(a<b-1){
            t = a + (b-a)/2
            if(nums[t]<target){
                a = t
            }else if(nums[t]>target){
                b=t;
            }else{
                return t
            }
        }
        if (nums[a] == target)return a
        if (nums[b] == target)return b
        return -1
    }
}
