class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        if(temperatures.length==0){
            return new int[0];
        }
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while(!stack.empty() && temperatures[stack.peek()]<temperatures[i]){
                    int temp = stack.pop();
                    result[temp] = i-temp;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
