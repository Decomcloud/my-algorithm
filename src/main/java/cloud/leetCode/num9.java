package cloud.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class num9 {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = String.valueOf(x).toCharArray();
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }

        int currentVal = 0;
        while (!stack.isEmpty()){
            currentVal = currentVal*10 + Integer.parseInt(stack.pop().toString());
        }
        return currentVal == x;
    }

    public static boolean isPalindrome2(int x) {
        StringBuilder sb = new StringBuilder();
        String s = sb.append(x).reverse().toString();
        return s.equals(String.valueOf(x));
    }

    public static boolean isPalindrome3(int x) {
        StringBuilder sb = new StringBuilder();
        String string = String.valueOf(x);
        for (int i = 0; i < (string.length() / 2) + 1; i++) {
            if(string.charAt(i)!= string.charAt(string.length() - i - 1)){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = isPalindrome(121);
        System.out.println(b);
        boolean b2 = isPalindrome2(121);
        System.out.println(b2);
        boolean b3 = isPalindrome3(15211251);
        System.out.println(b3);
    }
}
