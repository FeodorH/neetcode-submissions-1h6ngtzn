class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        TreeMap<Integer,PriorityQueue<Integer>> map = new TreeMap<>();
        for(int[] el : intervals){
            if(map.containsKey(el[0])){
                map.get(el[0]).add(el[1]);
            }else{
                PriorityQueue<Integer> t = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
                t.add(el[1]);
                map.put(el[0],t);
            }
        }

        int c = 0;
        int thisEnd = -1;
        for(int key : map.keySet()){
            PriorityQueue<Integer> thisVals = map.get(key);
            if(thisEnd <= key) thisEnd = -1;
            if(thisEnd != -1){
                thisVals.add(thisEnd);
            }
            while (thisVals.size()>1){
                thisVals.poll();
                c++;
            }
            thisEnd = thisVals.peek();
        }
        return c;
    }
}
