package cloud.leetCode;

public class num3 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(j, i);
            int pos = str.indexOf(s.charAt(i), j);
            if(pos < 0){
                max = s.length() - i;
                break;
            }
            max = Math.max(max, pos - i);
        }
        return max;
    }

    public static void main(String[] args) {
        /*int l1 = lengthOfLongestSubstring("abc");
        System.out.println(l1);*/
        int l2 = lengthOfLongestSubstring("abcabcbb");
        System.out.println(l2);
        /*int l3 = lengthOfLongestSubstring(" ");
        System.out.println(l3);*/
    }
}
