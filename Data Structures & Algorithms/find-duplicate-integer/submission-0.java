class Solution {
    public int findDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(nums.length/32 + 1, 0));
        for(int i = 0; i < nums.length; i++){
            nums[i] --;

            int el = list.get(nums[i]/32)&(1<<(nums[i]%32));//to
            if(el == 0){
                list.set(nums[i]/32,list.get(nums[i]/32)|(1<<(nums[i]%32)));
                nums[i]++;
            }
            else {
                return ++nums[i];
            }
        }
        return -1;
    }
}
