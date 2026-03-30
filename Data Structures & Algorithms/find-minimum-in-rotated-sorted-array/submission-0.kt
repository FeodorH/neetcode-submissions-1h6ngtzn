class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var m = nums.size/2
        var r = nums.size-1
        while(l!=m&&r!=m){
            if(nums[r]<nums[m]){
                l=m
                m=l+(r-l)/2
            }else
            if(nums[l]>nums[m]){
                r=m
                m=l+(r-l)/2
            }else{
                break
            }
        }
        return Math.min(nums[l],nums[r])
    }
}