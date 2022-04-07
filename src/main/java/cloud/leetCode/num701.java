package cloud.leetCode;

public class num701 {
    public static int reverse(int x) {
        long reverse = 0;
        char[] array = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            sb.append(array[i]);
        }
        if(x >= 0){
            sb.append(array[0]);
            reverse = Long.parseLong(sb.toString());
        }else {
            reverse = Long.parseLong(sb.toString()) * -1;
        }
        if(reverse>Integer.MAX_VALUE || reverse< Integer.MIN_VALUE){
            return 0;
        }
        return (int) reverse;
    }

    public static int reverse2(int x) {
        long reverse = 0;
        while (x!=0){
            int val = x % 10;
            x = x/10;
            reverse = reverse * 10 + val;
        }
        if(reverse>Integer.MAX_VALUE || reverse< Integer.MIN_VALUE){
            return 0;
        }
        return (int)reverse;
    }

    public static void main(String[] args) {
        int reverse = reverse(-2147483648);
        System.out.println(reverse);
        int reverse2 = reverse2(-2147483648);
        System.out.println(reverse2);
    }
}
