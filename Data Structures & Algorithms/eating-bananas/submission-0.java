class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int b = 0;
        for (int p : piles) b = Math.max(b, p);
        int a = 1;
        while(b-a>1){
            int mid = (a+b)/2;
            int c = 0;
            for(int el : piles){
                c+= (el + mid - 1) / mid;
            }
            if(c<=h){
                b = mid;
            }else {
                a = mid;
            }
        }
        int c = 0;
        for(int el : piles){
            c+=(el + a - 1) / a;
        }
        if(c<=h){
            return a;
        }else {
            return b;
        }
    }
}
