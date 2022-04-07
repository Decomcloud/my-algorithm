package cloud.leetCode;

import java.util.Stack;

public class num20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() == 0){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = getValue(c);
            if (value > 0){
                stack.push(c);
            } else if (value < 0){
                if(stack.isEmpty()){
                    return false;
                }
                int s1 = getValue(stack.pop());
                if(s1 != (value * -1)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static int getValue(char ch) {
        switch(ch) {
            case '(': return 1;
            case '{': return 2;
            case '[': return 3;
            case ')': return -1;
            case '}': return -2;
            case ']': return -3;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        boolean b1 = isValid("()");
        System.out.println(b1);

        boolean b2 = isValid("[");
        System.out.println(b2);
    }
}
