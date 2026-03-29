class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length>1) {
            int max_profit = 0;
            int a=0,b=1;
            while (b<prices.length){
                if(prices[a]>prices[b]){
                    a++;
                    b++;
                }else {
                    if(max_profit<prices[b]-prices[a]){
                        max_profit = prices[b]-prices[a];
                    }
                    b++;
                }
            }
            b--;
            while (a<b){
                max_profit = Math.max(max_profit,prices[b]-prices[a]);
                a++;
            }
            return max_profit > 0 ? max_profit : 0;
        }else return 0;
    }
}
