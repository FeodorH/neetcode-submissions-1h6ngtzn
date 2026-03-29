class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> t1 = new HashSet<>();
        t1.add('{');
        t1.add('(');
        t1.add('[');
        Set<Character> t2 = new HashSet<>();
        t2.add('}');
        t2.add(')');
        t2.add(']');
        for(int i =0;i<s.length();i++){
            if(t1.contains(s.charAt(i))){
                stack.add(s.charAt(i));
            }

            if(t2.contains(s.charAt(i))){
                char c = s.charAt(i);
                if(stack.empty())return false;
                if(c=='}'&&stack.pop()!='{'){
                    return false;
                }
                if(c==')'&&stack.pop()!='('){
                    return false;
                }
                if(c==']'&&stack.pop()!='['){
                    return false;
                }
            }
            System.out.println(stack.toString());
        }
        System.out.println(stack.toString());
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
