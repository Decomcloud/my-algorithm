package cloud.leetCode;

public class num28 {
    public static int strStr(String haystack, String needle) {

        if(needle.isEmpty()){
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(needle.charAt(0) == haystack.charAt(i)){
                int j = 1;
                while (j < needle.length()){
                    if(needle.charAt(j) != haystack.charAt(i + j)){
                        break;
                    }
                    j ++;
                }
                if(j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int strStr2(String haystack, String needle) {

        boolean b = haystack.contains(needle);
        return b?haystack.indexOf(needle): -1;
    }

    public static void main(String[] args) {
        /*int str1 = strStr("aaaaa", "bba");
        System.out.println(str1);

        int str2 = strStr("hello", "ll");
        System.out.println(str2);*/

        int str3 = strStr("mississippi", "issip");
        System.out.println(str3);
    }

}
