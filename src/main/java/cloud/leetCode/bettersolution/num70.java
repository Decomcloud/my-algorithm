package cloud.leetCode.bettersolution;

public class num70 {
    public static int climbStairs2(int n) {
        if(n == 0){
            return 0;
        }
        if (n == 1 || n ==2){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);

    }

    public static int climbStairs(int n) {
        int first = 0;
        if(n == 0){
            return first;
        }
        if (n == 1 || n ==2){
            return n;
        }
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return first + second;

    }

    public static void main(String[] args) {
        int i1 = climbStairs(5);
        System.out.println(i1);
    }
}
