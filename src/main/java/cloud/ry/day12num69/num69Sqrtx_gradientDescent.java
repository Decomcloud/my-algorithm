package cloud.ry.day12num69;
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 991 👎 0

public class num69Sqrtx_gradientDescent {
    public static void main(String[] args) {
        Solution solution = new num69Sqrtx_gradientDescent().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            double n = 1;
            double alpha = getAlpha(x);
            int i = 1;
            while (Math.abs(n * n - x) > 0.001) {
                n = n - alpha * 4 * n * (n * n - x);
                System.out.println("====================");
                System.out.println("迭代x" + (i++) + ":" + n);
                System.out.println("====================");
            }
            int ans = (int) n;
            return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
        }

        public double getAlpha(int x) {
            double alpha = 100;
            int z = x;
            while (z > 0) {
                alpha *= 10;
                z = z / 10;
            }
            return (double) 1 / (alpha);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}