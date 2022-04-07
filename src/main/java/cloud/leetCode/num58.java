package cloud.leetCode;

public class num58 {
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }

    public static int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        int i1 = lengthOfLastWord(s1);
        System.out.println(i1);

        String s2 = " ";
        int i2 = lengthOfLastWord(s2);
        System.out.println(i2);
    }
}
