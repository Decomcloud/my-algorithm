package cloud.leetCode;

public class num66 {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        /*int[] array1 = plusOne(new int[]{1, 2, 3});
        for (int value : array1) {
            System.out.print(value);
        }*/

        int[] array2 = plusOne(new int[]{1, 2, 9});
        for (int value : array2) {
            System.out.print(value);
        }
    }
}
