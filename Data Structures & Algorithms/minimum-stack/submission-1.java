class MinStack {

    Stack<Integer> data;
    TreeMap<Integer,Integer> mins;

    public MinStack() {
        data = new Stack<>();
        mins = new TreeMap();
    }

    public void push(int val) {
        data.push(val);
        if(mins.containsKey(val)){
            mins.put(val,mins.get(val)+1);
        }else {
            mins.put(val,1);
        }
    }

    public void pop() {
        int temp = data.pop();
        if(mins.get(temp)!=1){
            mins.put(temp,mins.get(temp)-1);
        }else {
            mins.remove(temp);
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return mins.firstKey();
    }
}