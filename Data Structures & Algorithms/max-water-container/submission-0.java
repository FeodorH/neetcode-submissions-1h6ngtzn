class Solution {
    public int maxArea(int[] heights) {
        int a = 0;
        int b = heights.length-1;
        int maxS = 0;
        while(a<b){
            int min = (heights[a]<heights[b])?a:b;
            int s = (b-a)*heights[min];
            maxS = Math.max(s,maxS);
            if(min==a)a++;
            else b--;
        }
        return maxS;
    }
}