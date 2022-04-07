package cloud.leetCode;

public class num38 {
    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 0; i <n-1; i++) {
            res = countNext(res);
        }
        return res;
    }

    public static String countNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt( i+ 1)){
                count ++;
            }else {
                sb.append(count).append(s.charAt(i));
                count = 1;
            }
        }
        sb.append(count).append(s.charAt(s.length() -1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String res4 = countAndSay(4);
        System.out.println(res4);
        String s2 = countNext("11");
        System.out.println(s2);
    }
}
