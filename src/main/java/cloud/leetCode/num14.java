package cloud.leetCode;

public class num14 {
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String common = strs[0];
        int val = common.length();
        for (int i = 1; i < strs.length; i++) {
            val = 0;
            for (int j = 0; j < (common.length() < strs[i].length()? common.length():strs[i].length()); j++) {
                if(String.valueOf(common.charAt(j)).equals(String.valueOf(strs[i].charAt(j)))){
                    val = j + 1;
                }else {
                    break;
                }
            }
            common = common.substring(0,val);
        }
        return common.substring(0,val);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String common = strs[0];
        if(strs.length == 1){
            return common;
        }
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < common.length(); j++) {
                if(common.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            common =  common.substring(0,j);
        }
        return common;
    }

    public static void main(String[] args) {
        String s1 = longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        System.out.println(s1);
        String s2 = longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(s2);
        String s3 = longestCommonPrefix(new String[]{});
        System.out.println(s3);

        String s4 = longestCommonPrefix(new String[]{"aa", "a"});
        System.out.println(s4);

        String s5 = longestCommonPrefix(new String[]{"a"});
        System.out.println(s5);

        String s6 = longestCommonPrefix(new String[]{"aaa", "aa", "aaa"});
        System.out.println(s6);

        String s7 = longestCommonPrefix(new String[]{"aca", "cba"});
        System.out.println(s7);
    }
}
