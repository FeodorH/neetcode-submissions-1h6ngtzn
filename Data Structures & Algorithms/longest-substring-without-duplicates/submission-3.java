class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() > 1) {
            int a = 0;
            int b = 1;
            int r = 1;
            HashSet<Character> t = new HashSet<>();
            t.add(s.charAt(0));
            while (b < s.length()) {
                if (!t.contains(s.charAt(b))) {
                    t.add(s.charAt(b));
                    b++;
                } else {
                    t.remove(s.charAt(a));
                    a++;
                }
                System.out.println(a+b+t.toString());
                r = Math.max(r, t.size());
            }
            return r;
        }else return s.length()==1?1:0;
    }
}
