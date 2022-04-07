package cloud.leetCode;

public class num7 {
    /*java.lang.NumberFormatException: For input string: "9646324351"
      at line 65, java.lang.NumberFormatException.forInputString
      at line 583, java.lang.Integer.parseInt
      at line 615, java.lang.Integer.parseInt
      at line 10, Solution.reverse
      at line 57, __DriverSolution__.__helper__
      at line 82, __Driver__.main*/
    public static int reverse(int x) {
        char[] array = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
        long val;
        if (x < 0) {
            StringBuilder at = sb.deleteCharAt(array.length - 1);
            System.out.println(at);
            val = Long.parseLong(String.valueOf(sb)) * -1;
        }else {
            val = Long.parseLong(String.valueOf(sb));
        }
        if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(val));
    }

    public static void main(String[] args) {
        int reverse = reverse(-123);
        System.out.println(reverse);
    }

}
